package com.geektext19.restapi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;
  //  @OneToMany(mappedBy = "author")
   // private List<Book> books;

    public Author() {}

    public Author(String firstName, String lastName, String biography, String publisher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

   // public List<Book> getBooks() {
     //   return books;
    //}

    //public void setBooks(List<Book> books) {
      //  this.books = books;
    }

//