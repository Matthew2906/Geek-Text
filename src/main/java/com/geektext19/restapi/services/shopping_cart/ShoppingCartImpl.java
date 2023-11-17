package com.geektext19.restapi.services.shopping_cart;

import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.entities.ShoppingCart;
import com.geektext19.restapi.entities.User;
import com.geektext19.restapi.repositories.book_sorting.BookSortingRepository;
import com.geektext19.restapi.repositories.shopping_cart.ShoppingCartRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShoppingCartImpl implements ShoppingCartInter {
    ShoppingCartRepositories shoppingCartRepository;
    BookSortingRepository bookSortingRepository;
    //UserRepository userRepository;

    public ShoppingCartImpl(ShoppingCartRepositories shoppingCartRepository, BookSortingRepository bookSortingRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookSortingRepository = bookSortingRepository;
        //this.userRepository = userRepository;
    }

    public double getSubtotalPrice(User username) {
        double returnPrice = 0;
        for(ShoppingCart s: shoppingCartRepository.findByUser(username)) {
            returnPrice += s.getBook().getPrice();
        }
        return returnPrice;
    }
    public void addBook(Book isbn, User username) {
        Iterable<Book> books = bookSortingRepository.findAll();
        for(Book b : books) {
            if(b.getIsbn().equals(isbn.getIsbn())) {
                ShoppingCart book = new ShoppingCart(username, isbn);
                shoppingCartRepository.save(book);
            }
        }
    }
    public List<Book> getListOfBooks(User username) {
        List<Book> books = new ArrayList<>();
        for(ShoppingCart s : shoppingCartRepository.findByUser(username)) {
                books.add(s.getBook());
        }
        return books;
    }
    public void deleteBook(Book isbn, User username) {
        Iterable<ShoppingCart> books = shoppingCartRepository.findAll();
        for(ShoppingCart b : books) {
            if(b.getBook().getIsbn().equals(isbn.getIsbn()) && b.getUser().equals(username)){
                shoppingCartRepository.delete(b);
            }
        }
    }
}
