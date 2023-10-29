package com.geektext19.restapi.services.book_sorting;
import com.geektext19.restapi.entities.Book;
import java.util.List;

public interface BookSorting {
    /**
     *
     * @param genre
     * @return
     */
    public List<Book> getBooksByGenre(String genre);

    /**
     *
     * @return
     */
    public List<Book> getTopSellers();

}
