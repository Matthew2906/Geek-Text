package com.geektext19.restapi.repositories.book_sorting;

import com.geektext19.restapi.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookSortingRepository extends CrudRepository<Book, String> {
    List<Book> findBookByGenre(String genre);
}
