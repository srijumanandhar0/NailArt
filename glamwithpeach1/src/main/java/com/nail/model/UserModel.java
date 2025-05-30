package com.nail.model;

import java.time.LocalDate;

public class UserModel {
    private int id;
    private String name;
    private String country;
    private String email;
    private String password; // corrected from LocalDate to String

    // Default constructor
    public UserModel() {
    }

    // Parameterized constructor
    public UserModel(int id, String name, String country, String email, String password) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

