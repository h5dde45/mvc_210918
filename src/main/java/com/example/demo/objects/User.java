package com.example.demo.objects;

import javax.validation.constraints.Size;

public class User {
    @Size(min = 6, message = "Имя должно быть больше 6 знаков")
    private String username;
    @Size(min = 5, max = 10, message = "Пароль должен быть от 5 до 10 знаков")
    private String password;
    private boolean admin;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
