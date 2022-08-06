package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.model.ProductDetails;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ebiz")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = {"", "/product"})
    public @NotNull List<ProductDetails> getProducts(@RequestParam(name = "productId", required = false) Integer id, @RequestParam(name = "productName", required = false) String name) {
        List<ProductDetails> list = null;
        if (id != null) {
            list = mapResponse(productService.getProduct(id));
        } else if (name != null) {
            list = mapResponse(productService.getProductByName(name));
        }else{
            list = mapResponse(productService.getAllProducts());
        }
        return list;
    }

    private List<ProductDetails> mapResponse(Product product) {
        List<ProductDetails> list = new ArrayList();
        ProductDetails productDetails = new ProductDetails();
        productDetails.setId(product.getId());
        productDetails.setName(product.getProductName());
        productDetails.setPrice(product.getPrice());
        list.add(productDetails);
        return list;
    }

    private List<ProductDetails> mapResponse(List<Product> products) {
        List<ProductDetails> list = new ArrayList();
        if (products.size() > 0) {
            for (Product p : products) {
                ProductDetails productDetails = new ProductDetails();
                productDetails.setName(p.getProductName());
                productDetails.setPrice(p.getPrice());
                productDetails.setId(p.getId());
                list.add(productDetails);
            }
        }
        return list;
    }
}
