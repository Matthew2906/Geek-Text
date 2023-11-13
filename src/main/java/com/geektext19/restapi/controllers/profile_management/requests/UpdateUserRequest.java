package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest extends BaseUserRequest {

    private String password;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String password, String fullName, String address) {
        super(fullName, address);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
