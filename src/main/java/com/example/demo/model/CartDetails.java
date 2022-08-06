package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
public class CartDetails {
    private List<CartItem> cartItems;
    private double totalCost;
}
