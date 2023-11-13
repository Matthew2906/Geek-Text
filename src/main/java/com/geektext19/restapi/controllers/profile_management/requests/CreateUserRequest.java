package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest extends BaseUserRequest {
    @NotBlank(message = "username field can't be empty or null")
    private String username;
    
    @NotBlank(message = "email field can't be empty or null")
    private String email;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String username, String password, String fullName, String email, String address) {
        super(password, fullName, address);
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
}
