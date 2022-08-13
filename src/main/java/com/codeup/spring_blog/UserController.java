package com.codeup.spring_blog;
import com.codeup.spring_blog.User;
import com.codeup.spring_blog.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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



}







