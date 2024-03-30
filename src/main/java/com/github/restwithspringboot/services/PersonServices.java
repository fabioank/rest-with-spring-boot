package com.github.restwithspringboot.services;

import com.github.restwithspringboot.dtos.PersonDTO;
import com.github.restwithspringboot.exceptions.ResourceNotFoundException;
import com.github.restwithspringboot.mapper.PersonMapper;
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
        return people.stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return PersonMapper.toDTO(person);
    }

    public PersonDTO create (PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        Person savedPerson = repository.save(person);
        return PersonMapper.toDTO(savedPerson);
    }

    public PersonDTO update (PersonDTO personDTO){
        Person person = repository.findById(personDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setAddress(personDTO.getAddress());
        person.setGender(personDTO.getGender());

        Person personUpdated = repository.save(person);
        return PersonMapper.toDTO(personUpdated);
    }



    public void delete(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(person);
    }
}
