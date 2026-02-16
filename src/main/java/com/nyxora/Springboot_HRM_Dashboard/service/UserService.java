package com.nyxora.Springboot_HRM_Dashboard.service;

import com.nyxora.Springboot_HRM_Dashboard.entity.User;
import com.nyxora.Springboot_HRM_Dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String register(User user){

        if(repo.existsByEmail(user.getEmail())){
            return "Email already exists";
        }

        repo.save(user);
        return "Registered Successfully";
    }


    public String login(String email,String password){

        Optional<User> user = repo.findByEmail(email);

        if(user.isEmpty())
            return "User not found";

        if(!user.get().getPassword().equals(password))
            return "Invalid password";

        return "Login Success";
    }
}