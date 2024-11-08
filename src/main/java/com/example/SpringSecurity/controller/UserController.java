package com.example.SpringSecurity.controller;


import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User register(@RequestBody User user){
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

return userService.verify(user);
    }

}
