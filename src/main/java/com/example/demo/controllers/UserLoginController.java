package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.model.UserLoginDetails;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserLoginService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ebiz")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @GetMapping(value = {"", "/login"})
    public @NotNull UserLoginDetails login(@RequestParam String userId, @RequestParam String password) {
       System.out.println("AAAAAAAAAAAA:::::"+userId);
        System.out.println("AAAAAAAAAAAA:::::"+password);
        return userLoginService.login(userId, password);
    }
}