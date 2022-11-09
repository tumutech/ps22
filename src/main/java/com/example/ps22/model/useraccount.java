package com.example.ps22.model;

public class useraccount {
    String username,password;
    public useraccount(String USERNAME, String PASSWORD){
        this.username = USERNAME;
        this.password = PASSWORD;
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
}
