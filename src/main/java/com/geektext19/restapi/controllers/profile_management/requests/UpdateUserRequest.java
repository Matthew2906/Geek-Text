package com.geektext19.restapi.controllers.profile_management.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest extends BaseUserRequest {

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String password, String fullName, String address) {
        super(password, fullName, address);
    }
}
