package com.codeup.spring_blog.controllers;

import org.springframework.web.bind.annotation.*;


public class PostController {


    @GetMapping(path = "/posts")
    @ResponseBody
    public String index() {
        return "posts";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public int individualPost(@PathVariable int id) {
        return id;
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String createPost() {
        return "createPosts";

    }

    @GetMapping("/index")
    @ResponseBody
    public String indexPage(){
    return "index";
    }

    @GetMapping("/show")
    @ResponseBody
    public String showPage(){
        return "show";
    }


}
