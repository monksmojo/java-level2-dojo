package com.bootcampassignment.RestfulWebService.Q2.service;

import com.bootcampassignment.RestfulWebService.Q2.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> empList = new ArrayList<>();
    static int empCount = 3;

    static {
        empList.add(new Employee(1, "fin", 23));
        empList.add(new Employee(2, "clark", 27));
        empList.add(new Employee(3, "emo", 28));
    }

    // get list of all employees
    public List<Employee> getAllEmp() {
        return empList;
    }

    // get a specific employee from the list
    public Employee getEmp(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // add employee to the list
    public Employee addEmp(Employee emp) {
        if (emp.getId() == null) {
            emp.setId(empCount += 1);
//            empList.add(emp);
//            return emp;
        }
//        else {
//            empList.add(emp);
//            return emp;
//        }

            empList.add(emp);
            return emp;
    }

    // delete a employee record
    public Employee removeEmp(Integer id){
        Iterator<Employee> empitr=empList.iterator();
        while (empitr.hasNext()){
            Employee emp=empitr.next();
            if (emp.getId()==id){
                empitr.remove(); // will remove employee from list
                return emp;
            }
        }
        return null;
    }

    // update existing employee details
    public Employee promoteEmployee(Employee employee){
        for (Employee emp:empList){
            if(emp.getId()==employee.getId()){
                emp.setName(employee.getName());
                emp.setAge(employee.getAge());
                return emp;
            }
        }
        return null;
    }

}
