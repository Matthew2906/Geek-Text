package com.geektext19.restapi.services.book_sorting;

import com.geektext19.restapi.controllers.book_sorting.requests.UpdateBookRequest;
import com.geektext19.restapi.entities.Book;


import java.util.List;

public interface BookSorting {
    /**
     *
     * @param genre
     * @return
     */
    List<Book> getBooksByGenre(String genre);

    /**
     *
     * @return
     */
    List<Book> getTopSellers();

    List<Book> getBooksByRating(double rating);

    void discountBooksByPublishers(double discount, String publisher);



}
