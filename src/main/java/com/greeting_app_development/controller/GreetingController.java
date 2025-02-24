package com.greeting_app_development.controller;

import com.greeting_app_development.entity.Greeting;
import com.greeting_app_development.dto.UserDTO;
import com.greeting_app_development.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // Handles GET requests to /greeting
    @GetMapping
    public Greeting getGreeting(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        return greetingService.getGreeting(userDTO);
    }

    // Handles GET requests to /greeting/{id}
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // Handles GET requests to /greeting/all
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // Handles PUT requests to /greeting/{id}
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {
        return greetingService.updateGreeting(id, greeting);
    }

    // Handles DELETE requests to /greeting/{id}
    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}