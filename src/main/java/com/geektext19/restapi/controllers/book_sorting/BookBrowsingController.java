package com.geektext19.restapi.controllers.book_sorting;

import com.geektext19.restapi.controllers.book_sorting.responses.BrowsingResponse;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.book_sorting.BookRepository;
import com.geektext19.restapi.services.book_sorting.BookSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookBrowsingController {

    private final BookSorting bookSorting;
    private final BookRepository bookRepository;

    @Autowired
    public BookBrowsingController(BookSorting bookSorting, BookRepository bookRepository){
        this.bookSorting = bookSorting;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre){
        return bookSorting.getBooksByGenre(genre);
    }

}


