package com.github.restwithspringboot.services;

import com.github.restwithspringboot.exceptions.ResourceNotFoundException;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){

        return repository.findAll();
    }
    public Person findById(Long id){

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

    }
    public Person create(Person person){
        return repository.save(person);
    }
    public Person update(Person person){

        Person entity = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);

    }
    public void delete(Long id){

        Person entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
