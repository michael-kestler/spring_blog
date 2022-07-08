package com.codeup.spring_blog;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class PostController {


    private final PostRepository postRepository;
    private UserRepository userRepository;
    private final EmailService emailService;

    public PostController(PostRepository postRepository, UserRepository userRepository,
                         EmailService emailService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts/index";
    }


    @GetMapping(path = "/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        model.addAttribute("posts", postRepository.findAllById(Collections.singleton(id)));
        return "posts/show";
    }

    @GetMapping("/users/{id}")
    public String userID(@PathVariable long id, Model model){
        User user = userRepository.getUserById(id);
        List<Post> posts = postRepository.getByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("posts", posts);

        return showPage();
    }

    @GetMapping(path = "/posts/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("user", new User());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String post(@ModelAttribute Post post) {
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if(post.getTitle().equals("") || post.getBody().equals("")){
            return "posts/create";
        }


        postRepository.save(post);
        return "redirect:/posts";
    }



    @GetMapping("/posts/show")
    public String showPage() {
        return "posts/show";
    }



    @GetMapping("posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        Post editPost = postRepository.getById(id);
        model.addAttribute("postToEdit", editPost);
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String saveEditedPost(@PathVariable long id, @RequestParam(name="postTitle") String postTitle, @RequestParam(name="postBody") String postBody) {
        Post postToEdit = postRepository.getById(id);
        postToEdit.setBody(postBody);
        postToEdit.setTitle(postTitle);
        postRepository.save(postToEdit);
        return "redirect:/posts";
    }




}