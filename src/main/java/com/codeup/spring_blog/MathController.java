package com.codeup.spring_blog;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{number}/and/{number1}")
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number1) {
        return "The sum of " + number + " and " + number1 + " is " + (number + number1);
    }
        @GetMapping("/subtract/{number3}/from/{number4}")
        @ResponseBody
        public String subtract(@PathVariable int number3, @PathVariable int number4){
            return "The difference of " + number3 + " and " + number4 + " is " + (number3 - number4);
      }

    @GetMapping("/multiply/{number3}/and/{number4}")
    @ResponseBody
    public String multiply(@PathVariable int number3, @PathVariable int number4){
        return "The product of " + number3 + " and " + number4 + " is " + (number3 * number4);
    }

    @GetMapping("/divide/{number3}/by/{number4}")
    @ResponseBody
    public String divide(@PathVariable int number3, @PathVariable int number4){
        return "The quotient of " + number3 + " and " + number4 + " is " + (number3 / number4);
    }



}
