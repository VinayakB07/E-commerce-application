package com.example.E_commerce_App.Service;

import com.example.E_commerce_App.Models.User;
import com.example.E_commerce_App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(User user){
        userRepository.save(user);
        return "user added successfully";
    }
}
