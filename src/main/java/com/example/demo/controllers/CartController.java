package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.CartDetails;
import com.example.demo.model.CartItem;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/ebiz")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/cart")
    public ResponseEntity<String> addToCart(@RequestBody CartItem cartItem,
                                                 @RequestParam("userId") Integer userId) throws ProductNotFoundException {
        Product product = productService.getProduct(cartItem.getProductDetails().getId());
        System.out.println("product to add"+  product.getProductName());
        User user = new User(userId);

        cartService.addToCart(cartItem, product, user);
        return new ResponseEntity<String>("Added to cart", HttpStatus.CREATED);

    }
    @GetMapping("/cart")
    public ResponseEntity<CartDetails> getCartItems(@RequestParam("id") Integer id) {
        User user = new User(id);
        CartDetails cartDetails = cartService.listCartItems(user);
        return new ResponseEntity<CartDetails>(cartDetails, HttpStatus.OK);
    }
    @PutMapping("/cart/{id}")
    public ResponseEntity<String> updateCartItem(@RequestBody CartItem cartItem,
                                                      @RequestParam("id") Integer id) {
        User user = new User(id);
        Product product = productService.getProduct(cartItem.getProductDetails().getId());
        cartService.updateCartItem(cartItem);
        return new ResponseEntity<String>("Product has been updated", HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cartItemId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable("cartItemId") int itemID) {

        cartService.deleteCartItem(itemID);
        return new ResponseEntity<String>("Item has been removed", HttpStatus.OK);
    }

}
