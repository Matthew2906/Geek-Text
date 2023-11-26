package com.geektext19.restapi.repositories.Book_detail;

import com.geektext19.restapi.entities.Author;
import com.geektext19.restapi.entities.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BookRepository extends CrudRepository<Book,String> {
   // Book findByISBN(String ISBN);

    Book findBookByIsbn(String ISBN);
    List<Book> findBookByAuthorId(Author authorId);
}

