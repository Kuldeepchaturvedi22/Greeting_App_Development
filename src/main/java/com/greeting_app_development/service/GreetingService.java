package com.greeting_app_development.service;

import com.greeting_app_development.entity.Greeting;
import com.greeting_app_development.dto.UserDTO;
import com.greeting_app_development.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return new Greeting(String.format(template, name));
    }

    public Greeting getGreetingById(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.orElse(null); // Return the greeting if found, otherwise return null
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, Greeting updatedGreeting) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setContent(updatedGreeting.getContent());
            return greetingRepository.save(greeting);
        } else {
            return null; // Or throw an exception if preferred
        }
    }

    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }
}