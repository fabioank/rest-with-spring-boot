package com.github.restwithspringboot.mapper;

import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.model.Person;

import java.util.Date;

public class PersonMapperV2 {

    public static PersonDTOV2 toDTOV2(Person Book) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(Book.getId());
        dto.setFirstName(Book.getFirstName());
        dto.setLastName(Book.getLastName());
        dto.setAddress(Book.getAddress());
        dto.setGender(Book.getGender());
        dto.setBirthDate(new Date());
        return dto;
    }

    public static Person toEntity(PersonDTOV2 dto) {
        Person Book = new Person();
        Book.setId(dto.getId());
        Book.setFirstName(dto.getFirstName());
        Book.setLastName(dto.getLastName());
        Book.setAddress(dto.getAddress());
        Book.setGender(dto.getGender());
        return Book;
    }
}
