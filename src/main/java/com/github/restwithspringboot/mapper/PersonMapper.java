package com.github.restwithspringboot.mapper;

import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person Book) {
        PersonDTO dto = new PersonDTO();
<<<<<<< HEAD
        dto.setKey(Book.getId());
        dto.setFirstName(Book.getFirstName());
        dto.setLastName(Book.getLastName());
        dto.setAddress(Book.getAddress());
        dto.setGender(Book.getGender());
=======
        dto.setKey(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        return dto;
    }

    public static Person toEntity(PersonDTO dto) {
<<<<<<< HEAD
        Person Book = new Person();
        Book.setId(dto.getKey());
        Book.setFirstName(dto.getFirstName());
        Book.setLastName(dto.getLastName());
        Book.setAddress(dto.getAddress());
        Book.setGender(dto.getGender());
        return Book;
=======
        Person person = new Person();
        person.setId(dto.getKey());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setAddress(dto.getAddress());
        person.setGender(dto.getGender());
        return person;
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }
}
