package com.codeup.spring_blog;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class PostController {


    private final PostRepository postRepository;
    private final UserRepository userRepository;
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
//        emailService.prepareAndSend(post, "post created", "Your post has been created");
        return "redirect:/posts";
    }



    @GetMapping("/posts/show")
    public String showPage() {
        return "posts/show";
    }



    @GetMapping("/posts/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepository.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post){
        post.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

//            (@PathVariable long id, @RequestParam(name="title") String title,
//                                 @RequestParam(name="body") String body) {

        postRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public String delete(@ModelAttribute Post post) {
        postRepository.delete(post);
        return "redirect:/posts";
    }


    @PostMapping("/search")
    public String search(Model model, @RequestParam(name="query") String query, Post post){
        List<Post> searchResults;
        searchResults = postRepository.search(query);
        model.addAttribute("searchResults", searchResults);
        model.addAttribute("query", query);
        model.addAttribute("posts", post);

        return "posts/search_results";
    }

    @GetMapping("/posts/search_results")
    public String showResults(@ModelAttribute(name = "searchResults") ArrayList<Post> searchResults) {
        return "posts/search_results";
    }


}