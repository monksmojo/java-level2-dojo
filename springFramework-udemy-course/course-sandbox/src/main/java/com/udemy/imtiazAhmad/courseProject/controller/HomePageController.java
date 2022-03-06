package com.udemy.imtiazAhmad.courseProject.controller;

import com.udemy.imtiazAhmad.courseProject.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/homePage")
public class HomePageController {

    @GetMapping(path = "/landingForm")
    public String landingForm(Model model){
        model.addAttribute("personData",new Person());
        return "landingForm";
    }

    @PostMapping(path = "/process-person-data")
    public String processFormData(Person person, RedirectAttributes attributes){
        // redirect data to another page
        // here we store data in database
        attributes.addFlashAttribute("person",person);
        return "redirect:/homePage/show-person-data";
    }

    @GetMapping(path = "/show-person-data")
    public  String showFormData(Person person) {
        return "resultOfLandingForm";
    }

}
