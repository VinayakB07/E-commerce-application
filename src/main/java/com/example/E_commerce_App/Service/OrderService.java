package com.example.E_commerce_App.Service;

import com.example.E_commerce_App.Enums.Payment;
import com.example.E_commerce_App.Models.Order;
import com.example.E_commerce_App.Models.Product;
import com.example.E_commerce_App.Models.User;
import com.example.E_commerce_App.Repository.OrderRepository;
import com.example.E_commerce_App.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public String createOrder(User user,String payment){
        List<Product>productList=productRepository.findAll();
        List<Product>orderList=new ArrayList<>();
        int totalPrice=0;
        for(Product product:productList){
            if(product.getName().charAt(0)=='A'||product.getName().charAt(0)=='a'){
                product.setOrderCount(product.getOrderCount()+1);
                orderList.add(product);
                totalPrice=totalPrice+product.getPrice();
            }
        }
        Order order=new Order();
        order.setUser(user);
        order.setPayment(Payment.valueOf(payment));
        order.setProductList(orderList);

        orderRepository.save(order);

        user.getOrderList().add(order);

        return "order created successfully";
    }


}
