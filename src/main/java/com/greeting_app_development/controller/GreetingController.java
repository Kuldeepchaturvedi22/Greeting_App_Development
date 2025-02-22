package com.greeting_app_development.controller;

import com.greeting_app_development.entity.Greeting;
import com.greeting_app_development.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";

    // Handles GET requests to /greeting/hello
    @GetMapping("/hello")
    public Greeting getGreeting() {
        // Returns a greeting message with a default content
        return new Greeting(String.format(template, "from BridgeLabz"));
    }

    // Handles POST requests to /greeting/post
    @PostMapping("/post")
    public Greeting postGreeting(@RequestBody User user) {
        // Returns a greeting message with the provided user's first and last name
        return new Greeting(String.format(template, user.getFirstName() + " " + user.getLastName() + " !"));
    }

    // Handles PUT requests to /greeting/put/{firstName}
    @PutMapping("/put/{firstName}")
    public Greeting putGreeting(@PathVariable String firstName,
                                @RequestParam(value = "lastName") String lastName) {
        // Returns a greeting message with the provided first and last name
        return new Greeting(String.format(template, firstName + " " + lastName + "!"));
    }

    // Handles DELETE requests to /greeting/delete/{name}
    @DeleteMapping("/delete/{name}")
    public Greeting deleteGreeting(@PathVariable String name) {
        // Returns a message indicating the user with the provided name was deleted
        return new Greeting(String.format("User name " + name + " Deleted successfully !"));
    }
}