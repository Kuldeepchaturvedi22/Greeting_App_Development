package com.greeting_app_development.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Field to store the content of the greeting message
    private String content;

    // Constructor to initialize the content field
    public Greeting(String content) {
        this.content = content;
    }

    // Default constructor
    public Greeting() {}

    // Getter method for id
    public Long getId() {
        return id;
    }

    // Getter method for content
    public String getContent() {
        return content;
    }
}