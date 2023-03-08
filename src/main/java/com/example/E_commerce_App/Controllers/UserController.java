package com.example.E_commerce_App.Controllers;

import com.example.E_commerce_App.Models.User;
import com.example.E_commerce_App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
