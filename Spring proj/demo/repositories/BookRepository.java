package com.example.demo.repositories;

import com.example.demo.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository  extends JpaRepository<BookModel,Integer> {


    List<BookModel> findByName(String name);
    Optional<BookModel> findById(Integer id);


}



