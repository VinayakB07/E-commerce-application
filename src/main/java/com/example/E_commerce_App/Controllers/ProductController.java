package com.example.E_commerce_App.Controllers;

import com.example.E_commerce_App.Models.Product;
import com.example.E_commerce_App.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add_product")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/get_product")
    public Product getProduct(@RequestBody String category){
        return productService.getProductWihMaxPrice(category);
    }

    @GetMapping("/get_highest_ordered")
    public Product getHighestOrderedProduct(){
        return productService.getHighestOrderedProduct();
    }
}
