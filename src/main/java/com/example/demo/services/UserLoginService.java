package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.model.CartDetails;
import com.example.demo.model.UserLoginDetails;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    UserRepository userRepository;
    public UserLoginDetails login(String userId, String password){
     User user = userRepository.findByUserIdAnePassword(userId, password);
     UserLoginDetails userLoginDetails = mapData(user);
    return userLoginDetails;
    }

    private UserLoginDetails mapData(User user){
        UserLoginDetails userLoginDetails = new UserLoginDetails();
        userLoginDetails.setUserName(user.getName());
        userLoginDetails.setLoggedIn(true);
        userLoginDetails.setCartDetails(new CartDetails());
        return userLoginDetails;
    }
}
