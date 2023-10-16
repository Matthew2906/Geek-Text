package com.geektext19.restapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Book_List")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "description")
    private String description;
    @Column(name = "Price")
    private double price;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "yearPublished")
    private int yearPublished;
    @Column(name = "copiesSold")
    private int copiesSold;

    public Book(){}

    public Book(String ISBN, String bookName, String description, double price,
           String author, String genre, int yearPublished, int copiesSold){
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
