package com.geektext19.restapi.entities;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    private String isbn;
    private String bookName;
    private String description;
    private double price;
    //private String author;
    private String genre;
    private String publisher;
    private int yearPublished;
    private int copiesSold;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author authorId;
    public Book(){}
    public Book(String isbn, String bookName, String description, double price, String genre, String publisher, int yearPublished, int copiesSold, double rating, Author authorId) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.rating = rating;
        this.authorId = authorId;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String ISBN) {
        this.isbn = ISBN;
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