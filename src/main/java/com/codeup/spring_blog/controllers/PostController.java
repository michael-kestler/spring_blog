package com.codeup.spring_blog.controllers;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {


    @GetMapping(path = "/posts/index")
//    @ResponseBody
    public String index(Model model) {

        ArrayList<Post> posts = new ArrayList<>();

        model.addAttribute("posts", posts);

        return "posts/index";
    }



//    @GetMapping(path = "/posts/{id}")
//    @ResponseBody
//    public int individualPost(@PathVariable int id) {
//        return id;
//    }
//
//    @GetMapping(path = "/posts/create")
//    @ResponseBody
//    public String createPost() {
//        return "createPosts";
//
//    }
//
//    @GetMapping("/index")
//    @ResponseBody
//    public String indexPage(){
//    return "index";
//    }
//
    @GetMapping("/posts/show")
    public String showPage(){
        return "posts/show";
    }


}
