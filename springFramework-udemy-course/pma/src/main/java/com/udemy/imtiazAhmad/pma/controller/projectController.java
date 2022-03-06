package com.udemy.imtiazAhmad.pma.controller;

import com.udemy.imtiazAhmad.pma.entity.Project;
import com.udemy.imtiazAhmad.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path ="/project")
public class projectController {

    @Autowired
    Project project;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(path = "/project-list")
    public String getProject(Model model){
        List<Project> projectList=new ArrayList<>();
        Iterable<Project> projectIterable=projectRepository.findAll();
        projectIterable.forEach(projectList::add);
        model.addAttribute("projectList",projectList);
        return "project/project-list";
    }

    @GetMapping(path = "/add-form")
    public String addProjectForm(Model model){
        model.addAttribute("project",project);
        return "project/add-project-form";
    }

    @PostMapping(path = "/save")
    public String saveProject(Model model,Project project){
        projectRepository.save(project);
        return "redirect:/project/project-list";
    }
}
