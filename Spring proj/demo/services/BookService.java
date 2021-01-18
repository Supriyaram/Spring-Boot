package com.example.demo.services;

import com.example.demo.models.AuthorsModel;
import com.example.demo.models.BookModel;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@Service
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    ArrayList<BookModel> booksList = new ArrayList<BookModel>();
    ArrayList<AuthorsModel> authorsModelList = new ArrayList<AuthorsModel>();

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public BookModel addData(BookModel book) {
        return bookRepository.save(book);

    }

    public List<BookModel> fetchAllData() {

        return bookRepository.findAll();


    }

    public List<BookModel> fetchOneData(String name) {
        //System.out.println(name);
        return bookRepository.findByName(name);

    }

    public Optional<BookModel> fetchAdd(Integer isbn, Integer authorId) {
        //System.out.println("uid:"+uId);
        //System.out.println("aId: "+aId);
        if(bookRepository.findById(isbn).isPresent()){
            System.out.println("user object present");
        }
        BookModel bok =bookRepository.findById(isbn).get();
        // System.out.println(user);
        AuthorsModel authorsModel = authorRepository.findById(authorId).get();


        if(!booksList.contains(authorsModel)) {
            booksList.add(bok);
            authorsModelList.add(authorsModel);


            authorsModel.setBooks(booksList);
            bok.setAuthors(authorsModelList);
            System.out.println(bok);
            System.out.println(authorsModelList);
            bookRepository.save(bok);
            authorRepository.save(authorsModel);
        }


        return null;


        //public UserRequest saveUser(UserRequest userRequest) {
        //  return demoRepository.save(userRequest);

        //}
    }
}

