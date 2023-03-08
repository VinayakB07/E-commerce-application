package com.example.E_commerce_App.Models;

import com.example.E_commerce_App.Enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private int price;

    private int orderCount;

    @ManyToOne
    @JoinColumn
    private Order order;


}
