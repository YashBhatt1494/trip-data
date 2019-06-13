package com.tripData.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
    private String welcomeMsg;

    public WelcomeController() {
        this.welcomeMsg = "Hello World";
    }

    @GetMapping
    public String index() {
        return this.welcomeMsg;
    }
}
