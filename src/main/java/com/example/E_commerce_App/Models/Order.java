package com.example.E_commerce_App.Models;

import com.example.E_commerce_App.Enums.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Product>productList=new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private Payment payment;

    @ManyToOne
    @JoinColumn
    private User user;
}
