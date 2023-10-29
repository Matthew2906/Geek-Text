package com.geektext19.restapi.repositories.book_sorting;

import com.geektext19.restapi.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookSortingRepository extends CrudRepository<Book, Integer> {

    List<Book> findBookByGenre(@Param("genre") String genre);
}
