package com.github.restwithspringboot.services;
import static org.mockito.Mockito.when;

import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.exceptions.RequiredObjectIsNull;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServicesTest {


    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonServices services;

    Person Book;
    PersonDTO BookDTO;

    @BeforeEach
    public void setUp(){
        Book = new Person(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
        BookDTO = new PersonDTO(1L, "Fabio", "Kulka", "Araucaria" ,"Male");
    }

    @Test
    void findAll() {
        List<Person> entities = new ArrayList<Person>();
        entities.add(Book);
        when(repository.findAll()).thenReturn(entities);

        var people = services.findAll();

        assertNotNull(people);
        assertEquals(1L, entities.get(0).getId());

    }

    @Test
    void findById() {
        Person entity = Book;
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = services.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]\n"));
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());

    }

    @Test
    void create() {
        Person entity = Book;

        Person persisted = Book;
        persisted.setId(1L);

        PersonDTO dto = BookDTO;

        when(repository.save(Book)).thenReturn(persisted);

        var result = services.create(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]\n"));
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());


    }

    @Test
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
    void createV2() {
    }

    @Test
    void update() {

        Person entity = Book;
        entity.setId(1L);

        Person persisted = Book;
        persisted.setId(1L);

        PersonDTO dto = BookDTO;

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(Book)).thenReturn(persisted);

        var result = services.update(dto);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertNotNull(result.toString().contains("links: [</api/Book/v1/1>;rel=\"self\"]\n"));
        assertEquals("Araucaria", result.getAddress());
        assertEquals("Fabio", result.getFirstName());
        assertEquals("Kulka", result.getLastName());
        assertEquals("Male", result.getGender());
    }

    @Test
    void delete() {

        Person entity = Book;
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        services.delete(1L);

    }
}