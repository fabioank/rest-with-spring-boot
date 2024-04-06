package com.github.restwithspringboot.services;

import com.github.restwithspringboot.controller.PersonController;
import com.github.restwithspringboot.dto.PersonDTO;
import com.github.restwithspringboot.dtov2.PersonDTOV2;
import com.github.restwithspringboot.exceptions.RequiredObjectIsNull;
import com.github.restwithspringboot.exceptions.ResourceNotFoundException;
import com.github.restwithspringboot.mapper.PersonMapper;
import com.github.restwithspringboot.mapper.PersonMapperV2;
import com.github.restwithspringboot.model.Person;
import com.github.restwithspringboot.repositories.PersonRepository;
import com.github.restwithspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    Logger logger = Logger.getLogger(UserServices.class.getName());

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one use by name: " + username + "!");
        var user = repository.findByUsername(username);
        if (user != null){
            return user;
        }else{
            throw new UsernameNotFoundException("Username" + username + "not found");
        }
    }
}
