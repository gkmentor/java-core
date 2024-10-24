package org.hagiakinh.spring.security.service;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private final Map<String, String> users = new HashMap<>();

    public UserService() {
        // For simplicity, using plain text passwords, but use hashed passwords in production.
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
