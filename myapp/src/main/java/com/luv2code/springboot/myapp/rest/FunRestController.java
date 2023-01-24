package com.luv2code.springboot.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World! Time on the server is: " + LocalDateTime.now();
    }

    @GetMapping("/team")
    public String teamInfo() {
        return "Team Name: " + teamName + ", Coach Name: " + coachName;
    }
}
