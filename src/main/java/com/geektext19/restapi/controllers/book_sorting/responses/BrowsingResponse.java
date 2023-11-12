package com.geektext19.restapi.controllers.book_sorting.responses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrowsingResponse {

    private String isbn;
    private String bookName;
    private String description;
    private double price;
    private String author;
    private String genre;
    private int yearPublished;
    private int copiesSold;

    public BrowsingResponse(){

    }

    public BrowsingResponse(String isbn, String bookName, String description, double price, String author, String genre, int yearPublished, int copiesSold) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }


    public String getDescription() {
        return description;
    }


    public double getPrice() {
        return price;
    }


    public String getAuthor() {
        return author;
    }


    public String getGenre() {
        return genre;
    }


    public int getYearPublished() {
        return yearPublished;
    }


    public int getCopiesSold() {
        return copiesSold;
    }

}
