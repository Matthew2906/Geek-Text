package com.geektext19.restapi.services.profile_management;

import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.entities.User;
import com.geektext19.restapi.repositories.profile_management.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ProfileManagementImpl implements ProfileManagement{
    private final UserRepository userRepository;

    public ProfileManagementImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUserDetails(String username){
        User user = userRepository.findByUsername(username);
        //check if username is null or not and throw Exception UserNotFoundException
        return new UserResponse(user.getUsername(),user.getFullName(), user.getEmail(),user.getAddress());
    }

    @Override
    public void createUser(CreateUserRequest request){
        User user = new User(request.getUsername(), request.getPassword(), request.getFullName(), request.getEmail(), request.getAddress());
        userRepository.save(user);
    }

    @Override
    public void updateUser(String username, UpdateUserRequest request){
        User user = userRepository.findByUsername(username);
        //check if username is null or not and throw Exception UserNotFoundException

        if (request.getFullName() != null){
            user.setFullName(request.getFullName());
        }

        if (request.getPassword() != null){
            user.setPassword(request.getPassword());
        }

        if (request.getAddress() != null){
            user.setAddress(request.getAddress());
        }

        userRepository.save(user);
    }
}
