package com.example.E_commerce_App.Service;

import com.example.E_commerce_App.Models.Product;
import com.example.E_commerce_App.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public String addProduct(Product product){
        productRepository.save(product);
        return "product added successfully";
    }
    public Product getProductWihMaxPrice(String category){
        List<Product> productList=productRepository.findAll();
        Product product=new Product();
        int maxPrice=Integer.MIN_VALUE;
        for(Product product1:productList){
           if(product1.getCategory().toString().equals(category)){
               if(product1.getPrice()>maxPrice){
                   maxPrice=product1.getPrice();
                   product=product1;
               }
           }
        }
        return product;
    }
    public Product getHighestOrderedProduct(){
        List<Product>productList=productRepository.findAll();
        int maxCount=Integer.MIN_VALUE;
        Product product=new Product();
        for(Product product1:productList){
            if(product1.getOrderCount()>maxCount){
                maxCount=product1.getOrderCount();
                product=product1;
            }
        }
        return product;
    }
}
