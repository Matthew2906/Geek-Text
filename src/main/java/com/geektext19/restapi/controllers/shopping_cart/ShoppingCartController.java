package com.geektext19.restapi.controllers.shopping_cart;

import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.entities.ShoppingCart;
import com.geektext19.restapi.entities.User;
import com.geektext19.restapi.services.shopping_cart.ShoppingCartInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ShoppingCartController.BASE_ENDPOINT)
public class ShoppingCartController {
    public final static String BASE_ENDPOINT = "/shopping-cart";
    private final ShoppingCartInter shoppingCart;

    public ShoppingCartController(ShoppingCartInter shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    @GetMapping("/getSubtotalPrice:{username}")
    public ResponseEntity<Double> getSubtotalPrice(@PathVariable User username) {
        double shopping = shoppingCart.getSubtotalPrice(username);
        return ResponseEntity.ok(shopping);
    }
    @PostMapping("/{username}/{isbn}")
    public ResponseEntity<ShoppingCart> addBook(@PathVariable User username, @PathVariable Book isbn) {
        shoppingCart.addBook(isbn, username);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getListOfBooks:{username}")
    public ResponseEntity<List<Book>> getListOfBooks(@PathVariable User username) {
        List<Book> book = shoppingCart.getListOfBooks(username);
        if(book.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.ok(book);
        }
    }

    @DeleteMapping("/{username}/{isbn}")
    public ResponseEntity<ShoppingCart> deleteBook(@PathVariable User username, @PathVariable Book isbn) {
        shoppingCart.deleteBook(isbn, username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
