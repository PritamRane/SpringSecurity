package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    //hello
    @GetMapping("/hello")
    public String getHello(HttpServletRequest request){
        return "Hello "+ request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    //all users
    @GetMapping("/")
    public List<User> getAllUsers(){
return this.userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }


    @PostMapping("/add")
    public User add(@RequestBody User user){
        return this.userService.addUser(user);
    }


}
