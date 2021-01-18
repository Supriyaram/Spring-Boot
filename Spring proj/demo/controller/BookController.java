package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    public BookService bookService;
    @Autowired
    public AuthorService authorService;


    //step1

    @PostMapping("/books")
    public BookModel addData(@RequestBody BookModel books) {

        return bookService.addData(books);
    }


    //step4
    @JsonView(Views.Internal.class)
    @GetMapping("/books/{name}")
    public List<BookModel> fetchOneData(@PathVariable String name) {
        return bookService.fetchOneData(name);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/books")
    public List<BookModel> fetchAllData(){
        return bookService.fetchAllData();
    }
    //step6
    //@JsonView(Views.Internal.class)
    @PutMapping("/books/{isbn}/{authorId}")
    public Optional<BookModel> fetchAdd(@PathVariable Integer isbn, @PathVariable Integer authorId)
    {

        return bookService.fetchAdd(isbn,authorId);
    }

    //@GetMapping("users/{id}")

}
//@RequestMapping(method = RequestMethod.GET, value = "/users/{id}/{id}")
//public UserRequest saveUser(@PathVariable Long u_id, @PathVariable Long a_id){
// UserRequest userRequest=new UserRequest();
//AddressRequest addressRequest=new AddressRequest();

//userRequest.setName(u_id.getName());
//userRequest.setId(user_id.getId());
//addressRequest.setId(address_id.getId());
//addressRequest.setStreet(address_id.getStreet());

//return  demoService.saveUser(userRequest);





