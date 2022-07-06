package com.codeup.spring_blog.controllers;


import com.codeup.spring_blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/profile")
    public String getProfile(Model model){
        model.addAttribute("post", new Post());
        return "profile";
    }
}






