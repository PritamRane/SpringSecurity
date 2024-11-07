package com.example.SpringSecurity.services;

import com.example.SpringSecurity.model.User1;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService1 {

    List<User1> user1s = new ArrayList<>();

    public UserService1(){
        user1s.add(new User1("pritam","abc","abc@gmail.com"));
        user1s.add(new User1("shbham","abcd","abcd@gmail.com"));
    }
    //get all users
    public List<User1> getAllUsers(){
        return this.user1s;
    }

    //get single user
    public User1 getUser(String username){
        return this.user1s.stream().filter((user1) -> user1.getUsername().equals(username)).findAny().orElse(null);
    }

    public User1 addUser(User1 user1){
        this.user1s.add(user1);
        return user1;
    }

}
