package br.com.erudio.controller;

import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private SimpleMath math;

    @Autowired
    private NumberConverter converter;

    @RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return math.sum(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo){
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return math.sub(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo){
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return math.mult(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo){
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return math.div(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return math.media(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number){
        if (!converter.isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        return math.sqrt(converter.convertToDouble(number));
    }



}
