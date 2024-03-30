package com.github.restwithspringboot.repositories;

import com.github.restwithspringboot.dtos.PersonDTO;
import com.github.restwithspringboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Long> {}
