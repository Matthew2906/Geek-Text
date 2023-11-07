package com.geektext19.restapi.controllers.profile_management.responses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    @NotBlank(message = "username field cannot be left in blank or null")
    private String username;
    private String fullName;
    private String email;
    private String address;

    public UserResponse() {
    }

    public UserResponse(String username, String fullName, String email, String address) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
