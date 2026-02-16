package com.nyxora.Springboot_HRM_Dashboard.controller;

import com.nyxora.Springboot_HRM_Dashboard.entity.User;
import com.nyxora.Springboot_HRM_Dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;


    // REGISTER API
    @PostMapping("/register")
    public String register(@RequestBody User user){
        return service.register(user);
    }


    // LOGIN API
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password){

        return service.login(email,password);
    }
}