package com.github.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD
import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
=======
@ResponseStatus(HttpStatus.NOT_FOUND)
>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17
public class RequiredObjectIsNull extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public RequiredObjectIsNull(String ex){
        super(ex);
    }
<<<<<<< HEAD
    public RequiredObjectIsNull(){
        super("It is not allowed to persist a null object!");
    }
=======


>>>>>>> 0a57b4b441af13694652ab33f71f8e1df22fca17

}

