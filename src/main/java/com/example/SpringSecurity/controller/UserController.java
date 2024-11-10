package com.example.SpringSecurity.controller;


import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);

    }

    @GetMapping("/hello")
    public String getHello(HttpServletRequest request){
        return "Hello "+ request.getSession().getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

return userService.verify(user);
    }

}
