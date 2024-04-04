package com.github.restwithspringboot.services;

import com.github.restwithspringboot.controller.PersonController;
<<<<<<< HEAD

=======
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.exceptions.RequiredObjectIsNull;
import com.github.restwithspringboot.exceptions.ResourceNotFoundException;
import com.github.restwithspringboot.mapper.PersonMapper;
import com.github.restwithspringboot.mapper.PersonMapperV2;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll() {
        List<Person> people = repository.findAll();

<<<<<<< HEAD
        List<PersonDTO> listBooks =  people.stream()
                .map(PersonMapper::toDTO)
                .toList();

        listBooks.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return listBooks;
=======
        List<PersonDTO> listPersons =  people.stream()
                .map(PersonMapper::toDTO)
                .toList();

        listPersons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return listPersons;
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
    }

    public PersonDTO findById(Long id) {

        Person Book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
<<<<<<< HEAD
        PersonDTO dto = PersonMapper.toDTO(Book);
=======
        PersonDTO dto = PersonMapper.toDTO(person);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        dto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return dto;
    }

<<<<<<< HEAD
    public PersonDTO create (PersonDTO BookDTO) {

        if(BookDTO == null) throw new RequiredObjectIsNull();

        Person Book = PersonMapper.toEntity(BookDTO);
        Person savedBook = repository.save(Book);
        PersonDTO dto = PersonMapper.toDTO(savedBook);
=======
    public PersonDTO create (PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        Person savedPerson = repository.save(person);
        PersonDTO dto = PersonMapper.toDTO(savedPerson);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public PersonDTOV2 createV2 (PersonDTOV2 BookDTO) {
        Person Book = PersonMapperV2.toEntity(BookDTO);
        Person savedBook = repository.save(Book);
        return PersonMapperV2.toDTOV2(savedBook);
    }

<<<<<<< HEAD
    public PersonDTO update (PersonDTO BookDTO){

        if(BookDTO == null) throw new RequiredObjectIsNull();

        Person Book = repository.findById(BookDTO.getKey())
=======
    public PersonDTO update (PersonDTO personDTO){
        Person person = repository.findById(personDTO.getKey())
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        Book.setFirstName(BookDTO.getFirstName());
        Book.setLastName(BookDTO.getLastName());
        Book.setAddress(BookDTO.getAddress());
        Book.setGender(BookDTO.getGender());

<<<<<<< HEAD
        Person BookUpdated = repository.save(Book);
        PersonDTO dto = PersonMapper.toDTO(BookUpdated);
=======
        Person personUpdated = repository.save(person);
        PersonDTO dto = PersonMapper.toDTO(personUpdated);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17

        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public void delete(Long id) {
        Person Book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(Book);
    }
}
