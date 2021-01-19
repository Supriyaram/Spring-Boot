package com.example.demo.services;

import com.example.demo.models.AuthorsModel;
import com.example.demo.models.BookModel;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;


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
        if (bookRepository.findById(isbn).isPresent()) {
            System.out.println("user object present");
        }
        BookModel bok = bookRepository.findById(isbn).get();
        // System.out.println(user);
        AuthorsModel author = authorRepository.findById(authorId).get();




        if (bok.getAuthorsList()==null && author.getBooks()==null )
        {
            ArrayList<BookModel> booksList=new ArrayList<BookModel>();
            ArrayList<AuthorsModel> authorsModelList= new ArrayList<AuthorsModel>();
            booksList.add(bok);
            authorsModelList.add(author);
            bok.setAuthorsList(authorsModelList);
            author.setBooks(booksList);
            bookRepository.save(bok);
            authorRepository.save(author);

        }
        else if(bok.getAuthorsList()!=null)

        {
           //ArrayList<AuthorsModel>b=new ArrayList<AuthorsModel>();
            bok.getAuthorsList().add(author);
            bookRepository.save(bok);
            //authorRepository.save(author);


            //bok.setAuthorsList(authorsModelList);
             //author.setBooks(author.getBooks());
            //booksList.add(bok);
            //authorsModelList.add(author);

            //bok.setAuthorsList(authorsModelList);
            //author.setBooks(booksList);

        }
        else if(author.getBooks()!=null)
        {

            author.getBooks().add(bok);
           // bookRepository.save(bok);
            authorRepository.save(author);

        }

        //System.out.println(bok.toString());
       // System.out.println(authorsModelList);



        return null;

    }
}
        //public UserRequest saveUser(UserRequest userRequest) {
        //  return demoRepository.save(userRequest);

        //}



