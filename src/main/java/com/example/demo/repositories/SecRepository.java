package com.example.demo.repositories;


import com.example.demo.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecRepository  extends JpaRepository<Address,Integer> {



}
