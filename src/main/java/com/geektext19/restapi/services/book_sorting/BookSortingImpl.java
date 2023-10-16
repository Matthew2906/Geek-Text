package com.geektext19.restapi.services.book_sorting;

import com.geektext19.restapi.controllers.book_sorting.requests.RetrieveBookList;
import com.geektext19.restapi.controllers.book_sorting.responses.BrowsingResponse;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.book_sorting.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSortingImpl implements BookSorting {

    private final BookRepository bookRepository;

    public BookSortingImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findBookByGenre(genre);
    }




}
