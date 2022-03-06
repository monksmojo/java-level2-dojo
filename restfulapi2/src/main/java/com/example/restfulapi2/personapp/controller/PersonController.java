package com.example.restfulapi2.personapp.controller;

import com.example.restfulapi2.personapp.model.Person;
import com.example.restfulapi2.personapp.model.Person1;
import com.example.restfulapi2.personapp.service.PersonService;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @Autowired
    private MessageSource messageSource;

    // internationalization
    // allowing messages to be shown in English, German and Swedish,
    // keeping English as default.
    // takes "username" as param
    // shows a localized message "Hello Username". (Use parameters in message properties)

    @Operation(summary = "internationalization\n allowing messages to be shown in English, German and Swedish,")
    @GetMapping(path = "/greetings/{username}")
    public String sayHello(@PathVariable String username) {
        return messageSource.getMessage("hello.messages", new String[]{username}, LocaleContextHolder.getLocale());
    }


    //getting the whole persons list
    @Operation(summary = "Returns the whole list of persons")
    @GetMapping(path = "/persons")
    public List<Person> getPersonList() {
        return personService.getPersonList();
    }


    ////*Content Negotiation
    //GET Method also fetch the list of users in XML format
    @Operation(summary = "getting a specific person & also fetch the list of users in XML format")
    @GetMapping(path = "/persons/{id}")    // getting a specific person
    public EntityModel<Person> getPerson(@PathVariable("id") Integer id) {
        Person p = personService.getPerson(id);
        if (p == null) {
            throw new UserNotFoundException("user not found with id->" + id);
        }

        //*HATEOAS
        //Configuring hateoas with your springboot application.
        //it returns User Details along with link to show all other users.
        EntityModel<Person> resource = new EntityModel<>(p);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getPersonList());
        resource.add(linkTo.withRel("find-all-persons"));
        return resource;
    } //end of getPerson method

    //*Content Negotiation
    //POST Method to create user details which can accept XML for user creation.
    //by adding com.fasterxml.jackson.dataformat dependency to build.gradle
    @Operation(summary = "posting a specific person & accept the data in XML format")

//    @RequestBody( @Content(mediaType = "application/json"))
    @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json"))

    @PostMapping(path = "/persons")
    public ResponseEntity<Object> createPerson(@RequestBody Person person) {
        Person savedPerson = personService.addPerson(person); // adding person

        // returning of the 201 created status code
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()// return /persons
                .path("/{id}")//add path /persons/{id}
                .buildAndExpand(savedPerson.getId())// convert {id} to person id
                .toUri();//convert it to URI

        return ResponseEntity.created(location).build();
    }

    //Deleting a specific user
    @Operation(summary = "deleting a specific user")
    @DeleteMapping(path = "/persons/delete/{id}")
    public List<Person> removeUser(@PathVariable Integer id) {
        Person deletedPerson = personService.removePerson(id);
        if (deletedPerson == null) {
            throw new UserNotFoundException("user not found with id->" + id);
        }

        return personService.getPersonList(); // returning the list of person after removing person
    }

    //Dynamic Filtering
    // sending only the person name and its hobby in the response
    @Operation(summary = "Dynamic Filtering sending only the person name and its hobby in the response\n")
    @GetMapping(path = "/persons/hobbies")
    public MappingJacksonValue getHobbies() {
        List<Person> personList = personService.getPersonList(); // return person list
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "hobby");

        FilterProvider hobbyFilter = new SimpleFilterProvider().addFilter("hobbyFilter", filter); // creating the filter

        MappingJacksonValue hobbyMap = new MappingJacksonValue(personList); // map the response base on the filter
        hobbyMap.setFilters(hobbyFilter);

        return hobbyMap;
    }

    // uri versioning
    // first uri gives basic detail version of the persons
    @Operation(summary = "uri versioning first uri gives basic detail version of the persons")
    @GetMapping(path = "/persons/version1")
    public List<Person> getPersonListV1() {
        return personService.getPersonList();
    }

    // second uri gives more enhanced details
    @Operation(summary = "uri versioning second uri gives more enhanced details of person")
    @GetMapping(path = "/persons/version2")
    public List<Person1> getPersonListV2() {
        return personService.getPersonList1();
    }

    // parameter versioning
    // first uri gives basic detail version of the persons
    @Operation(summary = "parameter versioning")
    @GetMapping(value = "/persons/param", params = "version=1")
    public List<Person> getPersonListV3() {
        return personService.getPersonList();
    }

    // second uri gives more enhanced details
    @Operation(summary = "parameter versioning")
    @GetMapping(value = "/persons/param", params = "version=2")
    public List<Person1> getPersonListV4() {
        return personService.getPersonList1();
    }

    // header parameter versioning
    // first uri gives basic detail version of the persons
    @Operation(summary = "header parameter versioning")
    @GetMapping(value = "/persons/header", headers = "api-version=1")
    public List<Person> getPersonListV5() {
        return personService.getPersonList();
    }

    // second uri gives more enhanced details
    @Operation(summary = "header parameter versioning")
    @GetMapping(value = "/persons/header", headers = "api-version=2")
    public List<Person1> getPersonListV6() {
        return personService.getPersonList1();
    }

    //  mime type versioning
    // first uri gives basic detail version of the persons
    @Operation(summary = "mime type versioning")
    @GetMapping(value = "/persons/produces", produces = "application/com.example.app-v1+json")
    public List<Person> getPersonListV7() {
        return personService.getPersonList();
    }

    // second uri gives more enhanced details
    @Operation(summary = "mime type versioning")
    @GetMapping(value = "/persons/produces", produces = "application/com.example.app-v2+json")
    public List<Person1> getPersonListV8() {
        return personService.getPersonList1();
    }

}
