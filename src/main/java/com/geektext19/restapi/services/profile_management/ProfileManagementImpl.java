package com.geektext19.restapi.services.profile_management;

import com.geektext19.restapi.controllers.profile_management.exceptions.UserNotFoundException;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserCreditCardRequest;
import com.geektext19.restapi.controllers.profile_management.requests.CreateUserRequest;
import com.geektext19.restapi.controllers.profile_management.requests.UpdateUserRequest;
import com.geektext19.restapi.controllers.profile_management.responses.UserResponse;
import com.geektext19.restapi.entities.CreditCard;
import com.geektext19.restapi.entities.User;
import com.geektext19.restapi.repositories.profile_management.CreditCardRepository;
import com.geektext19.restapi.repositories.profile_management.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ProfileManagementImpl implements ProfileManagement{
    private final UserRepository USER_REPOSITORY;
    private final CreditCardRepository CREDIT_CARD_REPOSITORY;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileManagementImpl.class);

    public ProfileManagementImpl(UserRepository USER_REPOSITORY, CreditCardRepository CREDIT_CARD_REPOSITORY) {
        this.USER_REPOSITORY = USER_REPOSITORY;
        this.CREDIT_CARD_REPOSITORY = CREDIT_CARD_REPOSITORY;
    }

    @Override
    public UserResponse getUserDetails(String username) throws UserNotFoundException{
        User user = USER_REPOSITORY.findByUsername(username);
        if(user == null){
            String errorMessage = "User " + username + " doesn't exist!";
            LOGGER.error(errorMessage);
            throw new UserNotFoundException(errorMessage) ;
        }
        return new UserResponse(user.getUsername(),user.getFullName(), user.getEmail(),user.getAddress());
    }

    @Override
    public void createUser(CreateUserRequest request){
        User user = new User(request.getUsername(), request.getPassword(), request.getFullName(), request.getEmail(), request.getAddress());
        USER_REPOSITORY.save(user);
    }

    @Override
    public void updateUser(String username, UpdateUserRequest request) throws UserNotFoundException {
        User user = USER_REPOSITORY.findByUsername(username);

        if(user == null){
            String errorMessage = "User " + username + " doesn't exist!";
            LOGGER.error(errorMessage);
            throw new UserNotFoundException(errorMessage) ;
        }

        if (request.getFullName() != null){
            user.setFullName(request.getFullName());
        }

        if (request.getPassword() != null){
            user.setPassword(request.getPassword());
        }

        if (request.getAddress() != null){
            user.setAddress(request.getAddress());
        }

        USER_REPOSITORY.save(user);
    }

    @Override
    public void addCreditCardToUser(String username, CreateUserCreditCardRequest request) throws UserNotFoundException {
        User user = USER_REPOSITORY.findByUsername(username);

        if(user == null){
            String errorMessage = "User " + username + " doesn't exist!";
            LOGGER.error(errorMessage);
            throw new UserNotFoundException(errorMessage) ;
        }

        CreditCard creditCard = new CreditCard(request.getCreditCardNumber(), request.getCardholderName(),
                                                        request.getExpirationDate(), request.getCvv(), user);

        CREDIT_CARD_REPOSITORY.save(creditCard);
    }
}
