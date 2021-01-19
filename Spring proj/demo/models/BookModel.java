package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isbn")
    @JsonView(Views.Public.class)
    private Integer isbn;

    @JsonView(Views.Public.class)
    private String name;



    @ManyToMany
    @JoinTable(
            name = "book_auth",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonView(Views.Public.class)
    private List<AuthorsModel> authors;


    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorsModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorsModel> authors) {
        this.authors = authors;
    }


}
