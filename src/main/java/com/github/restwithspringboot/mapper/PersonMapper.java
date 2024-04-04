package com.github.restwithspringboot.mapper;

import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        PersonDTO dto = new PersonDTO();

        dto.setKey(Book.getId());
        dto.setFirstName(Book.getFirstName());
        dto.setLastName(Book.getLastName());
        dto.setAddress(Book.getAddress());
        dto.setGender(Book.getGender());
=======
        dto.setKey(person.getId());
=======
        dto.setId(person.getId());
>>>>>>> parent of b114a0e (Implementado a entidade Book)
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
<<<<<<< HEAD
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
=======
>>>>>>> parent of b114a0e (Implementado a entidade Book)
        return dto;
    }

    public static Person toEntity(PersonDTO dto) {
<<<<<<< HEAD
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
=======
        Person person = new Person();
        person.setId(dto.getId());
>>>>>>> parent of b114a0e (Implementado a entidade Book)
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setAddress(dto.getAddress());
        person.setGender(dto.getGender());
        return person;
<<<<<<< HEAD
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
=======
>>>>>>> parent of b114a0e (Implementado a entidade Book)
    }
}
