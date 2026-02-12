package kh.edu.paragoniu.helloworldapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldAppApplication.class, args);
    }

    @GetMapping
    public String home(){
        return "Welcome to my Web Site. </br> <b>Hello World</b> ";
    }

}
