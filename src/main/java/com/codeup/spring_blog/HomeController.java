package com.codeup.spring_blog;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String intro(){
        return "This is a landing page.";
           }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }


}
