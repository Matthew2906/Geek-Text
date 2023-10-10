package com.geektext19.restapi.services.profile_management;

import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;

public interface ProfileManagement {
    /**
     * returns user details given an username
     * @param username the username to search by
     * @return UserResponse with the details of the user
     */
    UserResponse getUserDetails(String username);

    /**
     * creates a User and stores it in Database
     * @param request the data to create the User
     */
    void createUser(CreateUserRequest request);
}
