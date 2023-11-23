package com.geektext19.restapi.services.book_sorting;

import com.geektext19.restapi.controllers.book_sorting.exceptions.BookSortingNotFoundException;
import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.book_sorting.BookSortingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookSortingImpl implements BookSorting {

    private final BookSortingRepository bookSortingRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookSortingImpl.class);

    public BookSortingImpl(BookSortingRepository bookSortingRepository) {
        this.bookSortingRepository = bookSortingRepository;
    }

    public List<Book> getBooksByGenre(String genre) throws BookSortingNotFoundException {
        List<Book> books = bookSortingRepository.findBookByGenre(genre);
        if(books.isEmpty()){
            String errorMessage = "No book found with genre: " + genre;
            LOGGER.error(errorMessage);
            throw new BookSortingNotFoundException(errorMessage);
        }
        return books;
    }


    public List<Book> getTopSellers() throws BookSortingNotFoundException{
        Iterable<Book> books = bookSortingRepository.findAll();
        List<Book> topSellers = new ArrayList<Book>();
        for(Book b : books){
            topSellers.add(b);
        }
        topSellers.sort(Comparator.comparingInt(Book::getCopiesSold).reversed());

        List<Book> top10Sold = new ArrayList<Book>();
        for(int i = 0; i < topSellers.size(); i++){
            if(i == 10){
                break;
            }else{
                top10Sold.add(topSellers.get(i));
            }
        }

        if(top10Sold.isEmpty()){
            String errorMessage = "No top sellers found!";
            LOGGER.error(errorMessage);
            throw new BookSortingNotFoundException(errorMessage);
        }

        return top10Sold;

    }

    public List<Book> getBooksByRating(double rating) throws BookSortingNotFoundException{
        Iterable<Book> books = bookSortingRepository.findAll();
        List<Book> ratingPlus = new ArrayList<>();
        for(Book b: books){
            if(b.getRating() >= rating){
                ratingPlus.add(b);
            }
        }

        if(rating < 0 || rating > 5){
            String errorMessage = "Invalid rating, please enter a number between 0 and 5";
            LOGGER.error(errorMessage);
            throw new BookSortingNotFoundException(errorMessage);
        } else if(ratingPlus.isEmpty()){
            String errorMessage = "No books found with rating: " + rating + " or higher!";
            LOGGER.error(errorMessage);
            throw new BookSortingNotFoundException(errorMessage);
        }
        return ratingPlus;
    }

    public void discountBooksByPublishers(double discount, String publisher) throws BookSortingNotFoundException{
        Iterable<Book> books = bookSortingRepository.findBookByPublisher(publisher);
        List<Book> checkBook = bookSortingRepository.findBookByPublisher(publisher);

        if(discount < 0 || discount > 100)
        {
            String errorMessage = "Invalid discount: " + discount + ". Please enter a discount in between 0-100.";
            LOGGER.error(errorMessage);
            throw new BookSortingNotFoundException(errorMessage);
        }
        else if(checkBook.isEmpty())
        {
            String errorMessage = "No book found with publisher: " + publisher;
            LOGGER.error(errorMessage);
            throw new BookSortingNotFoundException(errorMessage);
        }
        else
        {
            for(Book b: books) {
                if (b.getPublisher() != null) {
                    b.setPrice(b.getPrice()-((discount/100)*b.getPrice()));
                    bookSortingRepository.save(b);
                }
            }
        }
    }




}
