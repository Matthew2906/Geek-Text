package com.geektext19.restapi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;
    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;
    public Author() {}

    public Author(String firstName, String lastName, String biography, String publisher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
    }

    public Author(String firstName, String lastName, String biography, String publisher, Long author_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.publisher = publisher;
        this.author_id = author_id;
    }

    public Long getId() {
        return author_id;
    }

    public void setId(Long author_id) {
        this.author_id = author_id;
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

}//