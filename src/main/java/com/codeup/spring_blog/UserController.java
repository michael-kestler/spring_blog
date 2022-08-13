package com.codeup.spring_blog;
import com.codeup.spring_blog.User;
import com.codeup.spring_blog.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public UserController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/users/sign-up")
    public String signupForm(Model model){
        model.addAttribute("user", new User());
            return "users/sign-up";
        }

    @PostMapping("/users/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String userLogout() {
        return "redirect:/login";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.getById(id));
        model.addAttribute("currentUser", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users/edit";
    }

    @PostMapping("users/edit")
    public String editListing(@ModelAttribute User user){
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        System.out.println(user.getPassword());
        userRepository.save(user);
        return "redirect:users/profile";
    }







}







