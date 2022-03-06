package com.udemy.imtiazAhmad.pma.controller;

import com.udemy.imtiazAhmad.pma.entity.Employee;
import com.udemy.imtiazAhmad.pma.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private Employee employee;

    @Autowired
    private  EmployeeRepository employeeRepository;

    @GetMapping(path = "/employee-list")
    public String getEmployeeList(Model model){
        List<Employee> employeeList=new ArrayList<>();
       Iterable<Employee> employeeIterable=employeeRepository.findAll();
       employeeIterable.forEach(employeeList::add);
       model.addAttribute("employeeList",employeeList);
       return "employee/employee-list";
    }

    @GetMapping(path ="/add-form")
    public String addEmployeeForm(Model model){
       model.addAttribute("employee",employee);
       return "employee/add-employee-form";
    }

    @PostMapping(path = "/save")
    public String saveEmployee(Model model,Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employee/employee-list";
    }


}
