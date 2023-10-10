package com.geektext19.restapi.services.profile_management;

import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.repositories.entities.User;
import org.springframework.stereotype.Service;


@Service
public class ProfileManagementImpl implements ProfileManagement{
    @Override
    public UserResponse getUserDetails(String username){
        System.out.println("The username is " + username);
        // TODO: CALL DB to get data
        return new UserResponse("pedrojuan", "Pedro Gonzalez", "pedro@gmail.com", "6649 NW");
    }

    @Override
    public void createUser(CreateUserRequest request){
        System.out.println("The username is " + request.getUsername());
        User user = new User(request.getUsername(), request.getPassword(), request.getFullName(), request.getEmail(), request.getAddress());
        // TODO: CALL DB to store data
    }
}
