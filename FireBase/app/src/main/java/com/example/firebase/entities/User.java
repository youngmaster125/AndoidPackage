package com.example.firebase.entities;

public class User {

    private  String usermane;
    private  String email;

    public User() {
    }

    public User(String usermane, String email) {
        this.usermane = usermane;
        this.email = email;
    }

    public String getUsermane() {
        return usermane;
    }

    public void setUsermane(String usermane) {
        this.usermane = usermane;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
