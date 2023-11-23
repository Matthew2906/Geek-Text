package com.geektext19.restapi.controllers.book_sorting;

import com.geektext19.restapi.controllers.book_sorting.exceptions.BookSortingNotFoundException;
import com.geektext19.restapi.entities.Book;

import com.geektext19.restapi.services.book_sorting.BookSorting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookBrowsingController.BASE_ENDPOINT)
public class BookBrowsingController {

    public final static String BASE_ENDPOINT = "/book-browsing";
    private final BookSorting bookSorting;

    public BookBrowsingController(BookSorting bookSorting){
        this.bookSorting = bookSorting;

    }

    @GetMapping("/genre:{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre){
        try {
            List<Book> book = bookSorting.getBooksByGenre(genre);
            return ResponseEntity.ok(book);
        } catch (BookSortingNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers(){
        try {
            List<Book> book = bookSorting.getTopSellers();
            return ResponseEntity.ok(book);
        } catch (BookSortingNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/rating:{rating}")
    public ResponseEntity<List<Book>> getBooksByRating(@PathVariable double rating){
        try {
            List<Book> book = bookSorting.getBooksByRating(rating);
            return ResponseEntity.ok(book);
        } catch (BookSortingNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/discount:{discount}/publisher:{publisher}")
    public ResponseEntity<List<Book>> discountBooksByPublisher(@PathVariable double discount, @PathVariable String publisher){
        try {
            bookSorting.discountBooksByPublishers(discount, publisher);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (BookSortingNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


