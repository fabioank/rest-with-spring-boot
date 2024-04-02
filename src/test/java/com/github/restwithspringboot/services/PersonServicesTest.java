package com.github.restwithspringboot.services;
import static org.mockito.Mockito.when;

import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.PrepareTestInstance;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServicesTest {


    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonServices services;

    Person person;
    PersonDTO personDTO;

    @BeforeEach
    public void setUp(){
        person = new Person(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
        personDTO = new PersonDTO(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        Person entity = person;
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = services.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]\n"));
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());

    }

    @Test
    void create() {
        Person entity = person;

        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = personDTO;

        when(repository.save(person)).thenReturn(persisted);

        var result = services.create(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]\n"));
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());


    }

    @Test
    void createV2() {
    }

    @Test
    void update() {

        Person entity = person;
        entity.setId(1L);

        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = personDTO;

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(person)).thenReturn(persisted);

        var result = services.update(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]\n"));
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());
    }

    @Test
    void delete() {

        Person entity = person;
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        services.delete(1L);

    }
}