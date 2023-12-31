package com.geektext19.restapi.services.Book_detail;

import com.geektext19.restapi.controllers.Book_details.request.CreateAuthorRequest;
import com.geektext19.restapi.controllers.Book_details.request.CreateBookRequest;
import com.geektext19.restapi.controllers.Book_details.responses.GetBookDetailsRequest;
import com.geektext19.restapi.entities.Author;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.Book_detail.AuthorRepository;
import com.geektext19.restapi.repositories.Book_detail.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookDetailsImpl implements BookDetails {
    private final BookRepository BOOK_REPOSITORY;
    private final AuthorRepository AUTHOR_REPOSITORY;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookDetailsImpl.class);

    public BookDetailsImpl(BookRepository BOOK_REPOSITORY, AuthorRepository AUTHOR_REPOSITORY) {
        this.BOOK_REPOSITORY = BOOK_REPOSITORY;
        this.AUTHOR_REPOSITORY = AUTHOR_REPOSITORY;
    }

    @Override
    public void createAuthor(CreateAuthorRequest request) {
        Author author = new Author(request.getFirstName(), request.getLastName(),
                request.getBiography(), request.getPublisher());
        AUTHOR_REPOSITORY.save(author);
    }


    @Override
    public void createBook(CreateBookRequest request) {
        Book book = new Book(request.getISBN(), request.getBookName(), request.getDescription(),
                request.getPrice(), request.getGenre(), request.getPublisher(),
                request.getYearPublished(),
                request.getCopiesSold(), request.getRating(), request.getAuthorId());
        BOOK_REPOSITORY.save(book);
    }

    public Book getBookDetails(String ISBN) {
        Book book = BOOK_REPOSITORY.findBookByIsbn(ISBN);
        return book;
    }

    public List<Book> getBooklist(Author author_id) {
        List<Book> book = BOOK_REPOSITORY.findBookByAuthorId(author_id);
        return book;
    }
}