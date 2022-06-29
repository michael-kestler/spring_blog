package com.codeup.spring_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Groovy Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(String name){
        return "Hello " + name + "!";
    }

}
