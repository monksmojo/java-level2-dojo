package com.udemy.imtiazAhmad.courseProject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hello-world")
public class HelloWorldController {

    @GetMapping(path = "/regular-hello")
    public String regularHello(){
        return "hello";
    }

    @GetMapping(path = "/special-hello-to/{name}")
    public String specialHello(@PathVariable String name){
        return "<h1>Hello how are you "+name+" </h1>";
    }

    @GetMapping(path = "/greeting-from-form")
    public String formGreeting(){
        return "<form action=\"/hello-world/form-result\" method=\"GET  \" id=\"nameform\">\n" +
                "  <label for=\"fname\">First name:</label>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\"><br><br>\n" +
                "  <label for=\"lname\">Last name:</label>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\">\n" +
                "</form>\n" +
                "\n" +
                "<p>The button below is outside the form element, but still part of the form.</p>\n" +
                "\n" +
                "<button type=\"submit\" form=\"nameform\" value=\"Submit\">Submit</button>";
    }

    @GetMapping(path = "/form-result")
    public String formResult(@RequestParam String fname,@RequestParam String lname){
     return "hello "+fname+" "+lname;
    }
}
