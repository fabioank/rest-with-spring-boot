package com.github.restwithspringboot.services;

<<<<<<< HEAD
import com.github.restwithspringboot.controller.PersonController;
<<<<<<< HEAD

=======
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
=======
>>>>>>> parent of b114a0e (Implementado a entidade Book)
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.exceptions.ResourceNotFoundException;
import com.github.restwithspringboot.mapper.PersonMapper;
import com.github.restwithspringboot.mapper.PersonMapperV2;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll() {
        List<Person> people = repository.findAll();
<<<<<<< HEAD

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
=======
        return people.stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
>>>>>>> parent of b114a0e (Implementado a entidade Book)
    }

    public PersonDTO findById(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
<<<<<<< HEAD
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
=======
        return PersonMapper.toDTO(person);
    }

    public PersonDTO create (PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        Person savedPerson = repository.save(person);
        return PersonMapper.toDTO(savedPerson);
>>>>>>> parent of b114a0e (Implementado a entidade Book)
    }
    public PersonDTOV2 createV2 (PersonDTOV2 personDTO) {
        Person person = PersonMapperV2.toEntity(personDTO);
        Person savedPerson = repository.save(person);
        return PersonMapperV2.toDTOV2(savedPerson);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public PersonDTO update (PersonDTO BookDTO){

        if(BookDTO == null) throw new RequiredObjectIsNull();

        Person Book = repository.findById(BookDTO.getKey())
=======
    public PersonDTO update (PersonDTO personDTO){
        Person person = repository.findById(personDTO.getKey())
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
=======
    public PersonDTO update (PersonDTO personDTO){
        Person person = repository.findById(personDTO.getId())
>>>>>>> parent of b114a0e (Implementado a entidade Book)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setAddress(personDTO.getAddress());
        person.setGender(personDTO.getGender());

<<<<<<< HEAD
<<<<<<< HEAD
        Person BookUpdated = repository.save(Book);
        PersonDTO dto = PersonMapper.toDTO(BookUpdated);
=======
        Person personUpdated = repository.save(person);
        PersonDTO dto = PersonMapper.toDTO(personUpdated);
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17

        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
=======
        Person personUpdated = repository.save(person);
        return PersonMapper.toDTO(personUpdated);
>>>>>>> parent of b114a0e (Implementado a entidade Book)
    }
    public void delete(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(person);
    }
}
