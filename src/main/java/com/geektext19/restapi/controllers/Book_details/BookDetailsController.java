package com.geektext19.restapi.controllers.Book_details;

import com.geektext19.restapi.controllers.Book_details.request.CreateBookRequest;
import com.geektext19.restapi.services.Book_detail.BookDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BookDetailsController.BASE_ENDPOINT)
public class BookDetailsController {
    public final static String BASE_ENDPOINT = "/book-details";

    private final BookDetails BOOK_DETAILS;

    public BookDetailsController(BookDetails bookDetails) {
        this.BOOK_DETAILS = bookDetails;
    }

    @PostMapping
    public ResponseEntity<CreateBookRequest> createBook(@RequestBody CreateBookRequest request){
        BOOK_DETAILS.createBook(request);
        return ResponseEntity.noContent().build();
    }
}
