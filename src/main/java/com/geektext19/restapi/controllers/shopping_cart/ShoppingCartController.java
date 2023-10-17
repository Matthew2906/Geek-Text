package com.geektext19.restapi.controllers.shopping_cart;

import com.geektext19.restapi.services.shopping_cart.ShoppingCart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ShoppingCartController.BASE_ENDPOINT)
public class ShoppingCartController {
    public final static String BASE_ENDPOINT = "/shopping-cart";
    private final ShoppingCart shoppingCart;

    public ShoppingCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
