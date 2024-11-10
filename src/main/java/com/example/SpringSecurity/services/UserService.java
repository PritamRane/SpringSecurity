package com.example.SpringSecurity.services;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;


    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager manager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(13); //encodes only first 72 chars


    public User         register(User user){
user.setPassword(encoder.encode(user.getPassword()));

return  repo.save(user);
    }

    public String verify(User users){
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(users.getUsername());

        return "Fail";
    }


}
