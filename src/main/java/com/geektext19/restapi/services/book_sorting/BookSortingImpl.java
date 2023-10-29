package com.geektext19.restapi.services.book_sorting;

import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.book_sorting.BookSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSortingImpl implements BookSorting {

    private final BookSortingRepository bookSortingRepository;

    public BookSortingImpl(BookSortingRepository bookSortingRepository) {
        this.bookSortingRepository = bookSortingRepository;
    }

    public List<Book> getBooksByGenre(String genre){
        return bookSortingRepository.findBookByGenre(genre);
    }




}
