package com.bootcampassignment.RestfulWebService.Q2.controller;

import com.bootcampassignment.RestfulWebService.Q2.exception.UserNotFoundException;
import com.bootcampassignment.RestfulWebService.Q2.service.EmployeeService;
import com.bootcampassignment.RestfulWebService.Q2.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService empquerry;

    // to see list of all employee
    @GetMapping(path = "/")
    public ResponseEntity<List<Employee>> requestEmpList() {

        return new ResponseEntity(empquerry.getAllEmp(), HttpStatus.OK);
    }

    // to see a specific employee
    @GetMapping(path = "/{id}")
    public Employee requestEmp(@PathVariable Integer id) {
        Employee foundedEmp=empquerry.getEmp(id);
        if(foundedEmp==null){
            throw new UserNotFoundException("User Not Found With id->"+id);
        }
        return foundedEmp;
    }

    // to add a new employee using post() method
    @PostMapping(path = "/")
    public ResponseEntity<Object> createEmp(@Valid @RequestBody Employee emp) {
        Employee savedEmployee = empquerry.addEmp(emp);
        //returning the status code
        URI location=ServletUriComponentsBuilder.fromCurrentRequestUri()// return /users
                .path("/{id}") //add path to uri->/users/{id}
                .buildAndExpand(savedEmployee.getId()) // replace d with {id}-> employee id
                .toUri();// convert it to uri

        return ResponseEntity.created(location).build(); // returning the created status
    }

    //to delete a employee from the list
    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Integer id){
        Employee exemp=empquerry.removeEmp(id);
        if(exemp==null){
            throw new UserNotFoundException("User Not Found With id->"+id);
        }
        return new ResponseEntity<>("the record has been deleted",HttpStatus.OK);
    }
    
    //to update a employee from the list
    @PutMapping(path = "/update")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee){
        employee = empquerry.promoteEmployee(employee);

        if(employee==null){
            throw new UserNotFoundException("User Not Found With id->"+employee.getId());
        }

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}