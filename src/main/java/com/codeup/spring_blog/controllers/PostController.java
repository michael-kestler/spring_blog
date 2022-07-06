package com.codeup.spring_blog.controllers;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
import repositories.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PostController {


    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts/index";
    }

//    @GetMapping(path = "/posts/index")
////    @ResponseBody
//    public String index(Model model) {
//
//        ArrayList<Post> posts = new ArrayList<>();
//
//        model.addAttribute("posts", posts);
//
//        return "posts/index";
//    }



//    @GetMapping(path = "/posts/{id}")
//    @ResponseBody
//    public int individualPost(@PathVariable int id) {
//        return id;
//    }
//
    @GetMapping(path = "/posts/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String post(@RequestParam("title") String title, @RequestParam("body") String body){
        postRepository.save(new Post(title, body));
        return "redirect:/posts";

    }

    @GetMapping("/posts/show")
    public String showPage(){
        return "posts/show";
    }


}
