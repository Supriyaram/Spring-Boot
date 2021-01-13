package com.example.demo.controller;


import com.example.demo.models.Address;
import com.example.demo.services.SecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecController {
    @Autowired
    public SecService secService;

    @PostMapping("/address")
    public Address addData(@RequestBody Address address)
    {
        return secService.addData(address);

    }

    @GetMapping("/address")
    public List<Address> fetchData()
    {
        return secService.fetchData();

    }




}
