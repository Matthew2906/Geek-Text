package com.geektext19.restapi.services.book_sorting;

import com.geektext19.restapi.entities.Book;
import com.geektext19.restapi.repositories.book_sorting.BookSortingRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookSortingImpl implements BookSorting {

    private final BookSortingRepository bookSortingRepository;

    public BookSortingImpl(BookSortingRepository bookSortingRepository) {
        this.bookSortingRepository = bookSortingRepository;
    }

    public List<Book> getBooksByGenre(String genre){
        List<Book> books = bookSortingRepository.findBookByGenre(genre);
        return books;
    }


    public List<Book> getTopSellers(){
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

        return top10Sold;
    }

    public List<Book> getBooksByRating(double rating){
        Iterable<Book> books = bookSortingRepository.findAll();
        List<Book> ratingPlus = new ArrayList<>();
        for(Book b: books){
            if(b.getRating() >= rating){
                ratingPlus.add(b);
            }
        }
        return ratingPlus;
    }

    public void discountBooksByPublishers(double discount, String publisher){
        Iterable<Book> books = bookSortingRepository.findBookByPublisher(publisher);
        for(Book b: books) {
            if (b.getPublisher() != null) {
                b.setPrice(b.getPrice()-((discount/100)*b.getPrice()));
                bookSortingRepository.save(b);
            }
        }
    }





}
