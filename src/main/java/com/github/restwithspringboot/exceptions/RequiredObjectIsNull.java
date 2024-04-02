package com.github.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequiredObjectIsNull extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public RequiredObjectIsNull(String ex){
        super(ex);
    }



}

