package com.geektext19.restapi.controllers.book_sorting;

import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.book_sorting.BookSortingRepository;
import com.geektext19.restapi.services.book_sorting.BookSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookBrowsingController {

    private final BookSorting bookSorting;
    private final BookSortingRepository bookSortingRepository;

    @Autowired
    public BookBrowsingController(BookSorting bookSorting, BookSortingRepository bookSortingRepository){
        this.bookSorting = bookSorting;
        this.bookSortingRepository = bookSortingRepository;
    }

    @GetMapping("/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre){
        return bookSorting.getBooksByGenre(genre);
    }

}


