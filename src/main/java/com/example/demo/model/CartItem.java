package com.example.demo.model;

import lombok.Data;
@Data
public class CartItem {
    private Integer id;
    private Integer quantity;
    private ProductDetails productDetails;

}
