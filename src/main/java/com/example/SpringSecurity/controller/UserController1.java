package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.User1;
import com.example.SpringSecurity.services.UserService1;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController1 {

    @Autowired
    private UserService1 userService1;

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
    public List<User1> getAllUsers(){
return this.userService1.getAllUsers();
    }

    @GetMapping("/{username}")
    public User1 getUser(@PathVariable("username") String username){
        return this.userService1.getUser(username);
    }


    @PostMapping("/add-user")
    public User1 add(@RequestBody User1 user1){
        return this.userService1.addUser(user1);
    }


}
