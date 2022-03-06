package com.udemy.imtiazAhmad.pma.controller;

import com.udemy.imtiazAhmad.pma.entity.Employee;
import com.udemy.imtiazAhmad.pma.entity.Project;
import com.udemy.imtiazAhmad.pma.repository.EmployeeRepository;
import com.udemy.imtiazAhmad.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/homepage")
public class HomepageController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(path = "/")
    public String getAllProjects(Model model){
        // getting all projects in a list from db
        List<Project> projectList=new ArrayList<Project>();
        Iterable<Project> projectIterable = projectRepository.findAll();
        projectIterable.forEach(projectList::add);
        // linking the list to the view through model
        model.addAttribute("projectList",projectList);

        // getting all employee in a list from db
        List<Employee> employeeList=new ArrayList<Employee>();
        Iterable<Employee> employeeIterable=employeeRepository.findAll();
        employeeIterable.forEach(employeeList::add);
        model.addAttribute("employeeList",employeeList);
        return "home-page";
    }
}
