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




}
