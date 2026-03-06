package kh.edu.paragoniu.helloworldapp.controller;

import jakarta.validation.Valid;
import kh.edu.paragoniu.helloworldapp.models.User;
import kh.edu.paragoniu.helloworldapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //When a user types ://yourwebsite.com into their browser address bar, this method is triggered.
    //the user GETS the signup page

    // /signup is just URL(web addresses). example: localhost:8080/signup
    @GetMapping("/signup")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "add-user";
    }


    @PostMapping("/adduser")
    //This is triggered when the user clicks the "Submit" button on your HTML form.
    // (Your HTML form must have method="post" and action="/adduser").
    //user fill out the form and POSTS the data to the server

    public String addUser(@Valid User user, BindingResult result)
    {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        return "redirect:/";
    }
    //@Valid makes sure the @NotBlank condition inside User.java is met before it saves
    //@Valid also allows the method hasErrors()
    //If @NotBlank is not met, instead of crashing or throwing an immediate exception, it will stores validation failure inside "result"
    // then result.hasErrors() = true and return "add-user" and user sees the message "Name is mandatory)

}
