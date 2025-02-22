package com.greeting_app_development.service;

import com.greeting_app_development.entity.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";

    public Greeting getSimpleGreeting() {
        return new Greeting(String.format(template, "World"));
    }
}