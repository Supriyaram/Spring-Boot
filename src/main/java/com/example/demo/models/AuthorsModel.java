package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


//@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class AuthorsModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    @JsonView(Views.Public.class)
    public Integer author_id;

    @JsonView(Views.Public.class)
    public String author_name;


    @ManyToMany(mappedBy = "authorsList")
    //@JoinColumn
    @JsonView(Views.Public.class)
    private List<BookModel> books;


    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }




}

