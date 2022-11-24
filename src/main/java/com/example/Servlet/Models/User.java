package com.example.Servlet.Models;

import java.util.List;
import java.util.Objects;

public class User {

    private String username,password;

    private int role_id;

    private List<User> users;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int role_id, List<User> users) {
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.users = users;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean hasRole(int hasRole) {
        for(User user : users) {
            if (user.getRole_id() == hasRole) {
                return true;
            }
        }
        return false;
    }
}
