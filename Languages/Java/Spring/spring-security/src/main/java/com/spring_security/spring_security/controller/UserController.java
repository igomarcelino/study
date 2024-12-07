package com.spring_security.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @GetMapping
    public String welcome(){
        return "Welcome to application USERS AUTH WITH JPA";
    }

    @GetMapping(value = "/admin")
    public String adminUsers(){
        return "Only Admin uses can see this content";
    }

    @GetMapping(value = "/users")
    public String userUsers(){
        return "Admin and Users can see this content";
    }
}
