package com.geektext19.restapi.controllers.profile_management.requests;

public abstract class BaseUserRequest {
    private String password;
    private String fullName;
    private String address;

    public BaseUserRequest() {
    }

    public BaseUserRequest(String password, String fullName, String address) {
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
