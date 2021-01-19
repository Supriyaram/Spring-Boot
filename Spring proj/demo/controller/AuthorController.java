package com.example.demo.controller;


import com.example.demo.models.AuthorsModel;
import com.example.demo.models.Views;
import com.example.demo.services.AuthorService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    public AuthorService authorService;

    @PostMapping("/authors")
    public AuthorsModel addData(@RequestBody AuthorsModel authorsModel)
    {
        return authorService.addData(authorsModel);

    }
    //step2
    @JsonView(Views.Public.class)
    @GetMapping("/authors")
    public List<AuthorsModel> fetchData()
    {
        return authorService.fetchData();

    }


    //step5
    @JsonView(Views.Public.class)
    @GetMapping("/authors/{name}")
    public List<AuthorsModel> fetchAData(@PathVariable String name) {
        return authorService.fetchAData(name);


        //
        // @PutMapping("/address/name"



    }













}
