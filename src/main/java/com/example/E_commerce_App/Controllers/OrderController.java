package com.example.E_commerce_App.Controllers;

import com.example.E_commerce_App.Models.Product;
import com.example.E_commerce_App.Models.User;
import com.example.E_commerce_App.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create_order")
    public String createOrder(@RequestBody User user, @RequestParam("payment") String payment){
        return orderService.createOrder(user,payment);

    }
}
