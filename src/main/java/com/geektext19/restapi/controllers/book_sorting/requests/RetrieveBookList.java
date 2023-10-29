package com.geektext19.restapi.controllers.book_sorting.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveBookList {

    private String ISBN;
    private String bookName;
    private String description;
    private double price;
    private String author;
    private String genre;
    private int yearPublished;
    private int copiesSold;

    public RetrieveBookList(){

    }

    public RetrieveBookList(String ISBN, String bookName, String description, double price, String author, String genre, int yearPublished, int copiesSold) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }
}
