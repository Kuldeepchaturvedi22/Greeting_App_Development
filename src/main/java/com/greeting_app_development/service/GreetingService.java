package com.greeting_app_development.service;

import com.greeting_app_development.entity.Greeting;
import com.greeting_app_development.dto.UserDTO;
import com.greeting_app_development.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting getGreeting(UserDTO userDTO) {
        String name;
        if (userDTO.getFirstName() != null && userDTO.getLastName() != null) {
            name = userDTO.getFirstName() + " " + userDTO.getLastName();
        } else if (userDTO.getFirstName() != null) {
            name = userDTO.getFirstName();
        } else if (userDTO.getLastName() != null) {
            name = userDTO.getLastName();
        } else {
            name = "World";
        }
        Greeting greeting = new Greeting(String.format(template, name));
        return greetingRepository.save(greeting);
    }
}