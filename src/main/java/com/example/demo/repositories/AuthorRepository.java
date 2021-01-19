package com.example.demo.repositories;


import com.example.demo.models.AuthorsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository  extends JpaRepository<AuthorsModel,Integer> {

    @Query(value = "select * from authors a where a.name = ?1", nativeQuery = true)
    List<AuthorsModel> findByAName(String name);



}
