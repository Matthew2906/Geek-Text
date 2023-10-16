package com.geektext19.restapi.repositories.book_sorting;

import com.geektext19.restapi.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findBookByGenre(@Param("genre") String genre);
}
