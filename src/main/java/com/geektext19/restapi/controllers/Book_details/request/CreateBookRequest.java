package com.geektext19.restapi.controllers.Book_details.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geektext19.restapi.entities.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookRequest {
    private String ISBN;
    private String bookName;
    private String description;
    private double price;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;
    private double rating;
    private Author authorId;

    public Author getAuthorId(){
        return authorId;
    }

    public void setAuthorId(Author authorId){
        this.authorId = authorId;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public double getRating(){ return rating;}

    public void setRating(double rating) {this.rating = rating;}
}