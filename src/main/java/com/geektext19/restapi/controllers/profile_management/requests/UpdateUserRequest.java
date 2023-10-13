package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Refactor into a base class (abstract BaseUserRequest main)

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest {
    private String password;
    private String fullName;
    private String address;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String password, String fullName, String address) {
        this.password = password;
        this.fullName = fullName;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
