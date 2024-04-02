package com.github.restwithspringboot.controller;

import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.restwithspringboot.util.MediaType;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    public PersonServices services;

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTO> findById(@PathVariable("id") Long id) {
        PersonDTO person = services.findById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> people = services.findAll();
        return ResponseEntity.ok(people);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
        PersonDTO createdPerson = services.create(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }
    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTOV2> createV2(@RequestBody PersonDTOV2 person) {
        PersonDTOV2 createdPerson = services.createV2(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person) {
        PersonDTO updatedPerson = services.update(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
