package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest extends BaseUserRequest {
    private String username;
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
