package com.example.demo.controller;


import com.example.demo.models.AddressModel;
import com.example.demo.models.Views;
import com.example.demo.services.AddressService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    public AddressService addressService;

    @PostMapping("/address")
    public AddressModel addData(@RequestBody AddressModel address)
    {
        return addressService.addData(address);

    }
    //step2
    @JsonView(Views.Public.class)
    @GetMapping("/address")
    public List<AddressModel> fetchData()
    {
        return addressService.fetchData();

    }


     //step5
     @JsonView(Views.Public.class)
    @GetMapping("/address/{street}")
    public List<AddressModel> fetchAData(@PathVariable String street) {
        return addressService.fetchAData(street);


     //
        // @PutMapping("/address/name"



    }













}
