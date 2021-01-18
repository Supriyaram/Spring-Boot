package com.example.demo.repositories;

import com.example.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {


     List<UserModel> findByName(String name);
    Optional<UserModel> findById(Integer id);


}



