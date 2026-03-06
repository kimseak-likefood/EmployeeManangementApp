package kh.edu.paragoniu.helloworldapp.controller;

import kh.edu.paragoniu.helloworldapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        int luckyNumberOfTheDay = (int) (Math.random() * 100);
        model.addAttribute("title", "Lucky number of the day is " + luckyNumberOfTheDay);
        model.addAttribute("message", "Hello World Web App");
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
