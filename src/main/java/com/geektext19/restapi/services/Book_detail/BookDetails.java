package com.geektext19.restapi.services.Book_detail;



import com.geektext19.restapi.controllers.Book_details.request.CreateAuthorRequest;
import com.geektext19.restapi.controllers.Book_details.request.CreateBookRequest;
import com.geektext19.restapi.controllers.Book_details.responses.GetBookDetailsRequest;
import com.geektext19.restapi.entities.Author;
import com.geektext19.restapi.entities.Book;

import java.util.List;

public interface BookDetails {
    /**
     *
     *
     * @param
     * @return
     */
    void createAuthor(CreateAuthorRequest request);

    /**
     *
     * @param request
     * @return
     */
    void createBook(CreateBookRequest request);
    Book getBookDetails(String isbn);
    List<Book> getBooklist(Author author_id);



}
