package com.example.SpringSecurity.repo;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Integer> {


    UserModel findByUsername(String username);
}
