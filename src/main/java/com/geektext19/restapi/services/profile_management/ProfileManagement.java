package com.geektext19.restapi.services.profile_management;

import com.geektext19.restapi.controllers.profile_management.exceptions.UserNotFoundException;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserCreditCardRequest;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;

public interface ProfileManagement {
    /**
     * returns user details given an username
     * @param username the username to search by
     * @return UserResponse with the details of the user
     */
    UserResponse getUserDetails(String username) throws UserNotFoundException;

    /**
     * creates a User and stores it in Database
     * @param request the data to create the User
     */
    void createUser(CreateUserRequest request);

    /**
     * Updates a User based on user request
     * @param username the username of the User to be updated
     * @param request the data to update
     */
    void updateUser(String username, UpdateUserRequest request) throws UserNotFoundException;

    /**
     * creates a CreditCard for a given user and given credit card object
     * @param username the username to which the credit card will be assigned to
     * @param baseRequest the credit card object
     * @throws UserNotFoundException
     */

    void addCreditCardToUser(String username, CreateUserCreditCardRequest baseRequest) throws UserNotFoundException;
}
