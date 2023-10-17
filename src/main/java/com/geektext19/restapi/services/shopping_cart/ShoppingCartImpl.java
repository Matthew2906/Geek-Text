package com.geektext19.restapi.services.shopping_cart;

import com.geektext19.restapi.repositories.shopping_cart.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartImpl implements ShoppingCart {
    private final UserRepository userRepository;

    public ShoppingCartImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
