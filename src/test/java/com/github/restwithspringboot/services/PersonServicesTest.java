package com.github.restwithspringboot.services;
import static org.mockito.Mockito.when;

import com.github.restwithspringboot.dto.PersonDTO;
<<<<<<< HEAD
import com.github.restwithspringboot.exceptions.RequiredObjectIsNull;
=======
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
=======
import org.junit.jupiter.api.TestInstance;
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;
=======
import org.springframework.test.context.event.annotation.PrepareTestInstance;

>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
<<<<<<< HEAD
class BookServicesTest {
=======
class PersonServicesTest {
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17


    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonServices services;

<<<<<<< HEAD
    Person Book;
    PersonDTO BookDTO;

    @BeforeEach
    public void setUp(){
        Book = new Person(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
        BookDTO = new PersonDTO(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
=======
    Person person;
    PersonDTO personDTO;

    @BeforeEach
    public void setUp(){
        person = new Person(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
        personDTO = new PersonDTO(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }

    @Test
    void findAll() {
<<<<<<< HEAD
        List<Person> entities = new ArrayList<Person>();
        entities.add(Book);
        when(repository.findAll()).thenReturn(entities);

        var people = services.findAll();

        assertNotNull(people);
        assertEquals(1L, entities.get(0).getId());

=======
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }

    @Test
    void findById() {
<<<<<<< HEAD
        Person entity = Book;
=======
        Person entity = person;
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = services.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
<<<<<<< HEAD
        assertNotNull(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]\n"));
=======
        assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]\n"));
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());

    }

    @Test
    void create() {
<<<<<<< HEAD
        Person entity = Book;

        Person persisted = Book;
        persisted.setId(1L);

        PersonDTO dto = BookDTO;

        when(repository.save(Book)).thenReturn(persisted);
=======
        Person entity = person;

        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = personDTO;

        when(repository.save(person)).thenReturn(persisted);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17

        var result = services.create(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
<<<<<<< HEAD
        assertNotNull(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]\n"));
=======
        assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]\n"));
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());


    }

    @Test
<<<<<<< HEAD
    void createWithNullBook() {

        Exception exception = assertThrows(RequiredObjectIsNull.class, () -> {
            services.create(null);
                });
        String expectedMessage = "It is not allowed to persist a null object!";
                String actualMessage = exception.getMessage();
        assertNotNull(actualMessage.contains(expectedMessage));

    }
    @Test
    void updateWithNullBook() {

        Exception exception = assertThrows(RequiredObjectIsNull.class, () -> {
            services.update(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertNotNull(actualMessage.contains(expectedMessage));

    }

    @Test
=======
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    void createV2() {
    }

    @Test
    void update() {

<<<<<<< HEAD
        Person entity = Book;
        entity.setId(1L);

        Person persisted = Book;
        persisted.setId(1L);

        PersonDTO dto = BookDTO;

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(Book)).thenReturn(persisted);
=======
        Person entity = person;
        entity.setId(1L);

        Person persisted = person;
        persisted.setId(1L);

        PersonDTO dto = personDTO;

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(person)).thenReturn(persisted);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17

        var result = services.update(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
<<<<<<< HEAD
        assertNotNull(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]\n"));
=======
        assertNotNull(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]\n"));
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());
    }

    @Test
    void delete() {

<<<<<<< HEAD
        Person entity = Book;
=======
        Person entity = person;
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        services.delete(1L);

    }
}