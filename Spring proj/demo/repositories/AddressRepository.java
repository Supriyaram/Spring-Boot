package com.example.demo.repositories;


import com.example.demo.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressModel,Integer> {

    @Query(value = "select * from address a where a.street = ?1", nativeQuery = true)
     List<AddressModel> findByAName(String street);



}
