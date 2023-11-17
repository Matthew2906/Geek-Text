package com.geektext19.restapi.services.shopping_cart;

import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.entities.User;

import java.util.List;

public interface ShoppingCartInter {
    public double getSubtotalPrice(User username);
    public void addBook(Book isbn, User username);

    public List<Book> getListOfBooks(User username);
    public void deleteBook(Book isbn, User username);
}
