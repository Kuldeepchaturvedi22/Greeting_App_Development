package com.greeting_app_development.controller;

import com.greeting_app_development.entity.Greeting;
import com.greeting_app_development.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // Autowire the GreetingService to use its methods
    @Autowired
    private GreetingService greetingService;

    // Handles GET requests to /greeting/simple
    @GetMapping("/hello")
    public Greeting getSimpleGreeting() {
        // Uses the service layer to get a simple greeting message
        return greetingService.getSimpleGreeting();
    }
}