package com.geektext19.restapi.services.book_sorting;
import com.geektext19.restapi.controllers.book_sorting.exceptions.BookSortingNotFoundException;
import com.geektext19.restapi.entities.Book;
import java.util.List;

public interface BookSorting {
    /**
     * returns a list of books by a given genre
     * @param genre
     * @return List of Book objects
     * @throws BookSortingNotFoundException
     */
    List<Book> getBooksByGenre(String genre) throws BookSortingNotFoundException;

    /**
     * returns a list of the ten highest sold books in descending order
     * @return List of Book Objects
     * @throws BookSortingNotFoundException
     */
    List<Book> getTopSellers() throws BookSortingNotFoundException;

    /**
     * returns a list of books by a given rating (0.0-5.0) or higher
     * @param rating
     * @return List of Book objects
     * @throws BookSortingNotFoundException
     */
    List<Book> getBooksByRating(double rating) throws BookSortingNotFoundException;

    /**
     * updates the price of books by a discount (0-100) under a given publisher
     * @param discount
     * @param publisher
     * @throws BookSortingNotFoundException
     */
    void discountBooksByPublishers(double discount, String publisher) throws BookSortingNotFoundException;

}
