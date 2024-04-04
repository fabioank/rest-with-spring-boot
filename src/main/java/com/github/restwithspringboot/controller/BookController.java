package com.github.restwithspringboot.controller;

import com.github.restwithspringboot.dto.BookDTO;
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.services.BookServices;
import com.github.restwithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.restwithspringboot.util.MediaType;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    public BookServices services;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<BookDTO> findById(@PathVariable("id") Long id) {
        BookDTO book = services.findById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public ResponseEntity<List<BookDTO>> findAll() {
        List<BookDTO> book= services.findAll();
        return ResponseEntity.ok(book);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://erudio.com.br"})
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO book) {
        BookDTO createdBook = services.create(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON,
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO book) {
        BookDTO updatedBook = services.update(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}
