package com.mavicstudy.store.UserRegistrationService;

public class User {
    private long id;
    private String email;
    private String Password;
    private String name;

    public User(long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        Password = password;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
