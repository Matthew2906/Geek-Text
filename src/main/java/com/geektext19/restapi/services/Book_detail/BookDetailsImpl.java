package com.geektext19.restapi.services.Book_detail;

import com.geektext19.restapi.controllers.Book_details.request.CreateAuthorRequest;
import com.geektext19.restapi.controllers.Book_details.request.CreateBookRequest;
import com.geektext19.restapi.controllers.Book_details.responses.GetBookDetailsRequest;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.Book_detail.AuthorRepository;
import com.geektext19.restapi.repositories.Book_detail.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookDetailsImpl implements BookDetails{
    private final BookRepository BOOK_REPOSITORY;
    private final AuthorRepository AUTHOR_REPOSITORY;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookDetailsImpl.class);

    public BookDetailsImpl(BookRepository BOOK_REPOSITORY,AuthorRepository AUTHOR_REPOSITORY ){
        this.BOOK_REPOSITORY = BOOK_REPOSITORY;
        this.AUTHOR_REPOSITORY = AUTHOR_REPOSITORY;
    }

    @Override
   public void createAuthor(CreateAuthorRequest request){

   }


    @Override
    public void createBook(CreateBookRequest request){
        Book book = new Book(request.getISBN(), request.getBookName(), request.getDescription(),
                request.getPrice(), request.getAuthorName(), request.getGenre(),request.getPublisher(),
                request.getYearPublished(),
                request.getCopiesSold(), request.getRating());
        BOOK_REPOSITORY.save(book);
    }
   public GetBookDetailsRequest getBookDetails(String ISBN){
       return null;
   }
    public List<Book> getBooklist(String author_id){
       return null;
    }
}
