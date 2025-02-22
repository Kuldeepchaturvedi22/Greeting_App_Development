package com.greeting_app_development.entity;

public class Greeting {
    // Field to store the content of the greeting message
    private final String content;

    // Constructor to initialize the content field
    public Greeting(String content) {
        this.content = content;
    }

    // Getter method for content
    public String getContent() {
        return content;
    }
}