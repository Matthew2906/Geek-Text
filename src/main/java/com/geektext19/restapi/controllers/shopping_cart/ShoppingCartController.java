package com.geektext19.restapi.controllers.shopping_cart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ShoppingCartController.BASE_ENDPOINT)

public class ShoppingCartController {
    public final static String BASE_ENDPOINT = "/shopping-cart";
//    private final ShoppingCart shoppingCart;
//
//    public ShoppingCartController(ShoppingCart shoppingCart) {
//        this.shoppingCart = shoppingCart;
//    }
//    @GetMapping("/{userID}")
//    public ResponseEntity<ShoppingCart shoppingCart>
}
