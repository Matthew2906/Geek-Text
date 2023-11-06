package com.geektext19.restapi.controllers.book_sorting;

import com.geektext19.restapi.entities.Book;

import com.geektext19.restapi.services.book_sorting.BookSorting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BookBrowsingController.BASE_ENDPOINT)
public class BookBrowsingController {

    public final static String BASE_ENDPOINT = "/book-browsing";
    private final BookSorting bookSorting;

    public BookBrowsingController(BookSorting bookSorting){
        this.bookSorting = bookSorting;

    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre){
        List<Book> book = bookSorting.getBooksByGenre(genre);
        return ResponseEntity.ok(book);
    }


    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers(){
        List<Book> book = bookSorting.getTopSellers();
        return ResponseEntity.ok(book);
    }
}


