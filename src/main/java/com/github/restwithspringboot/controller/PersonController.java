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

//@CrossOrigin
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    public PersonServices services;

<<<<<<< HEAD
    @CrossOrigin(origins = "http://localhost:8080")
=======
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTO> findById(@PathVariable("id") Long id) {
        PersonDTO Book = services.findById(id);
        return ResponseEntity.ok(Book);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> people = services.findAll();
        return ResponseEntity.ok(people);
    }

<<<<<<< HEAD
    @CrossOrigin(origins = {"http://localhost:8080", "https://erudio.com.br"})
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO Book) {
        PersonDTO createdBook = services.create(Book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
=======
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
        PersonDTO createdPerson = services.create(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }
    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
<<<<<<< HEAD
    public ResponseEntity<PersonDTOV2> createV2(@RequestBody PersonDTOV2 Book) {
        PersonDTOV2 createdBook = services.createV2(Book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
=======
    public ResponseEntity<PersonDTOV2> createV2(@RequestBody PersonDTOV2 person) {
        PersonDTOV2 createdPerson = services.createV2(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
<<<<<<< HEAD
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO Book) {
        PersonDTO updatedBook = services.update(Book);
        return ResponseEntity.ok(updatedBook);
=======
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person) {
        PersonDTO updatedPerson = services.update(person);
        return ResponseEntity.ok(updatedPerson);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
