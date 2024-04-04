package com.github.restwithspringboot.mapper;

import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person Book) {
        PersonDTO dto = new PersonDTO();
        dto.setKey(Book.getId());
        dto.setFirstName(Book.getFirstName());
        dto.setLastName(Book.getLastName());
        dto.setAddress(Book.getAddress());
        dto.setGender(Book.getGender());
        return dto;
    }

    public static Person toEntity(PersonDTO dto) {
        Person Book = new Person();
        Book.setId(dto.getKey());
        Book.setFirstName(dto.getFirstName());
        Book.setLastName(dto.getLastName());
        Book.setAddress(dto.getAddress());
        Book.setGender(dto.getGender());
        return Book;
    }
}
