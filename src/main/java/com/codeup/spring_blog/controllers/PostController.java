package com.codeup.spring_blog.controllers;

import com.codeup.spring_blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.codeup.spring_blog.repositories.PostRepository;
import com.codeup.spring_blog.repositories.UserRepository;

@Controller
public class PostController {


    private final PostRepository postRepository;
    private UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
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
    public String post(@RequestParam("title") String title, @RequestParam("body") String body) {
        postRepository.save(new Post(title, body));
        return "redirect:posts/index";

    }

    @GetMapping("/posts/show")
    public String showPage() {
        return "posts/show";
    }


    @GetMapping("posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepository.getById(id));
        return "posts/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post){
        postRepository.save(post);
        return "redirect:/posts/index";
    }



}