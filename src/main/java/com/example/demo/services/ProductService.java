package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProduct(Integer id) {
        Product product = productRepository
                .findByProductId(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not find with this id :" + id);
        }
        return product;
    }

    public List<Product> getProductByName(String name) {
        return productRepository
                .findByProductName(name);
    }

}
