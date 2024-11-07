package com.example.SpringSecurity.services;

import com.example.SpringSecurity.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User("pritam","abc","abc@gmail.com"));
        users.add(new User("shbham","abcd","abcd@gmail.com"));
    }
    //get all users
    public List<User> getAllUsers(){
        return this.users;
    }

    //get single user
    public User getUser(String username){
        return this.users.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user){
        this.users.add(user);
        return user;
    }

}
