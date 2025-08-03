package org.example.service;

import org.example.entity.Product;
import org.example.repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public void createProduct(Product prod){
        ProductRepo.addProduct(prod);
    }
}