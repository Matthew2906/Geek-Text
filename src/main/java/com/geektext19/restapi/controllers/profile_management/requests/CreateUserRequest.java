package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest extends BaseUserRequest {
    @NotBlank(message = "username field can't be empty or null")
    private String username;

    private String email;

    @NotBlank(message = "password field can't be empty or null")
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String username, String password, String fullName, String email, String address) {
        super(fullName, address);
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
