package com.github.restwithspringboot;

import com.github.restwithspringboot.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {

    private static final String template = "Hello, %s";
    private static final String idade = null;
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            {
                if(!MathMethods.isNumeric(numberOne) || !MathMethods.isNumeric(numberTwo) ){
                    throw new UnsuportedMathOperationException("Please set a numeric value");
                }
        return MathMethods.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo){

        if(!MathMethods.isNumeric(numberOne) || !MathMethods.isNumeric(numberTwo)){
            throw  new UnsuportedMathOperationException("Please set a numeric value");
        }
        return Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
    }
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo){

        if(!MathMethods.isNumeric(numberOne) || !MathMethods.isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Plese set a numeric value");
        }

        return Double.parseDouble(numberOne) * Double.parseDouble(numberTwo);
    }
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo){

        if(!MathMethods.isNumeric(numberOne) || MathMethods.isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        return Double.parseDouble(numberOne) / Double.parseDouble(numberTwo);
    }
    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo){

        if(!MathMethods.isNumeric(numberOne) || MathMethods.isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please ser a numeric value");
        }

        return (Double.parseDouble(numberOne) + Double.parseDouble(numberTwo)) / 2;
    }
}
