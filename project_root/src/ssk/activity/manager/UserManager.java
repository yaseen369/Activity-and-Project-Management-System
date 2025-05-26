package ssk.activity.manager;

import ssk.activity.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private Map<String, User> userMap;

    public UserManager() {
        this.userMap = new HashMap<>();
    }

    public User registerUser(String username, String password) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.out.println("Invalid username or password. Cannot register user.");
            return null;
        }
        if (userMap.containsKey(username)) {
            System.out.println("User with username '" + username + "' already exists.");
            return null;
        }
        User newUser = new User(username, password);
        userMap.put(username, newUser);
        System.out.println("User '" + username + "' registered successfully.");
        return newUser;
    }

    public User login(String username, String password) {
        User user = userMap.get(username);
        if (user != null && user.verifyPassword(password)) {
            System.out.println("Login successful for user: " + username);
            return user;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    public User getUserByUsername(String username) {
        return userMap.get(username);
    }

    public void displayUsers() {
        if (userMap.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("--- User List ---");
        for (User user : userMap.values()) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("-----------------");
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
