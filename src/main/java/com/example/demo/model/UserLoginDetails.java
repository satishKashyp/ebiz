package com.example.demo.model;

import lombok.Data;

@Data
public class UserLoginDetails {
    private String userId;
    private String password;
    private String userName;
    private boolean isLoggedIn;
    private CartDetails cartDetails;
}
