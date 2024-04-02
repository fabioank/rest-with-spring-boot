package com.github.restwithspringboot.services;

import com.github.restwithspringboot.controller.PersonController;
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
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
import java.util.stream.Collectors;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll() {
        List<Person> people = repository.findAll();

        List<PersonDTO> listPersons =  people.stream()
                .map(PersonMapper::toDTO)
                .toList();

        listPersons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return listPersons;
    }

    public PersonDTO findById(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        PersonDTO dto = PersonMapper.toDTO(person);
        dto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return dto;
    }

    public PersonDTO create (PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        Person savedPerson = repository.save(person);
        PersonDTO dto = PersonMapper.toDTO(savedPerson);
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public PersonDTOV2 createV2 (PersonDTOV2 personDTO) {
        Person person = PersonMapperV2.toEntity(personDTO);
        Person savedPerson = repository.save(person);
        return PersonMapperV2.toDTOV2(savedPerson);
    }

    public PersonDTO update (PersonDTO personDTO){
        Person person = repository.findById(personDTO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setAddress(personDTO.getAddress());
        person.setGender(personDTO.getGender());

        Person personUpdated = repository.save(person);
        PersonDTO dto = PersonMapper.toDTO(personUpdated);

        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public void delete(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(person);
    }
}
