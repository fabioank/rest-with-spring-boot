package com.github.restwithspringboot.controller;

import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id){
        Person person = new Person();
        person = services.findById(id);
        return person;
    }
    @GetMapping
    public List<Person> findAll(){

        return services.findAll();
    }
    @PostMapping
    public Person create(@RequestBody Person person) {

        return services.create(person);
    }
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {

        return services.update(person);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {

    services.delete(id);
    }

}
