package com.example.FilterSecurity.service;

import java.util.HashMap;
import java.util.Map;

import com.example.FilterSecurity.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    public UserService() {
        // Initialize with dummy users
        users.put("user1", new User("user1", "password123", "USER"));
        users.put("admin1", new User("admin1", "admin123", "ADMIN"));
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
