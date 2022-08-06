package com.example.demo.services;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.model.CartDetails;
import com.example.demo.model.CartItem;
import com.example.demo.model.ProductDetails;
import com.example.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private  CartRepository cartRepository;

    public CartService(){}

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(CartItem cartItem, Product product, User user){
        Cart cart = cartRepository.findByUserAndProduct(user,product);
        if(cart !=null){
            cart.setQuantity(cart.getQuantity()+1);
        }else {
            cart = new Cart();
            cart.setUser(user);
            cart.setQuantity(cartItem.getQuantity());
            cart.setProduct(product);
       }
        cartRepository.save(cart);
    }


    public CartDetails listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUser(user);
        List<CartItem> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(cart.getQuantity());
            cartItem.setId(cart.getId());
            cartItem.setProductDetails(setProductDetails(cart.getProduct()));
            cartItems.add(cartItem);
        }
        double totalCost = 0;
        for (CartItem cartItem :cartItems){
            totalCost += (cartItem.getProductDetails().getPrice()* cartItem.getQuantity());
        }
        CartDetails cartDetails=new CartDetails();
        cartDetails.setTotalCost(totalCost);
        cartDetails.setCartItems(cartItems);
        return cartDetails;
    }

    public void updateCartItem(CartItem cartItem){
        Cart cart = cartRepository.getOne(cartItem.getId());
        cart.setQuantity(cartItem.getQuantity());
        cartRepository.save(cart);
    }

    private ProductDetails setProductDetails(Product product){
        ProductDetails details = new ProductDetails();
        details.setDescription(product.getProductName());
        details.setName(product.getProductName());
        details.setPrice(product.getPrice());
        details.setId(product.getId());
        return details;

    }

    public void  deleteCartItem(int id)  {
        cartRepository.deleteById(id);

    }


}