package com.geektext19.restapi.controllers.Book_details;

import com.geektext19.restapi.controllers.Book_details.request.CreateAuthorRequest;
import com.geektext19.restapi.controllers.Book_details.request.CreateBookRequest;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.services.Book_detail.BookDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookDetailsController.BASE_ENDPOINT)
public class BookDetailsController {
    public final static String BASE_ENDPOINT = "/book-details";

    private final BookDetails BOOK_DETAILS;

    public BookDetailsController(BookDetails bookDetails) {
        this.BOOK_DETAILS = bookDetails;
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody CreateBookRequest request){
        BOOK_DETAILS.createBook(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookDetails(@PathVariable String isbn){
        Book bookDetails = BOOK_DETAILS.getBookDetails(isbn);
        return ResponseEntity.ok(bookDetails);
                //bookDetails != null ? ResponseEntity.ok(bookDetails) : ResponseEntity.notFound().build();
    }

    @PostMapping("/author")
    public ResponseEntity<?> createAuthor(@RequestBody CreateAuthorRequest request) {
        BOOK_DETAILS.createAuthor(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/author/{authorId}/books")
    public ResponseEntity<List<Book>> getBooklist(@PathVariable String authorId) {
        List<Book> books = BOOK_DETAILS.getBooklist(authorId);
        return ResponseEntity.ok(books);
        // return books.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(books);
    }
}
