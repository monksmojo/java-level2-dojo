package com.udemy.imtiazAhmad.courseProject.controller;

import com.udemy.imtiazAhmad.courseProject.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/{userId}",method = RequestMethod.GET)
    public String findUser(@PathVariable Integer userId){
        return "user found with id->"+userId;
    }

    @GetMapping(path = "/{userId}/invoice")
    public String getUserInvoice(@PathVariable Integer userId, @RequestParam(value = "date",required = false)Date dateOrNull ){
        return "user invoice found"+userId+"of date"+dateOrNull;
    }

    @GetMapping(path = "/petNames")
    public List<String> getUserPetNames(){
        return Arrays.asList("dog","cat","hamster");
    }

    @GetMapping(path = "/products")
    public List<Product> getUserProducts(){
        return Arrays.asList(new Product(1,"jeans",67.89),
                new Product(2,"t-shirt",50.46),
                new Product(3,"chinos",80.65    ));
    }
}
