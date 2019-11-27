package com.si2001.rentalcarspring.entities.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LoginDTO implements Serializable {

    @NotEmpty(message = "{NotEmpty.LoginDTO.username.validation}")
    private String username;
    @NotEmpty(message = "{NotEmpty.LoginDTO.password.validation}")
    private String password;

    public LoginDTO() {
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

    @Override
    public String toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
