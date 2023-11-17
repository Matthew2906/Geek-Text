package com.geektext19.restapi.repositories.shopping_cart;

import com.geektext19.restapi.entities.ShoppingCart;
import com.geektext19.restapi.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingCartRepositories extends CrudRepository<ShoppingCart, String> {
    List<ShoppingCart> findByUser(User user);
}
