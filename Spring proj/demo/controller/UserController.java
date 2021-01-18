package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.services.UserService;
import com.example.demo.services.AddressService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    public AddressService addressService;


    //step1

    @PostMapping("/users")
    public UserModel addData(@RequestBody UserModel user) {

        return userService.addData(user);
    }


    //step4
    @JsonView(Views.Internal.class)
    @GetMapping("/users/{name}")
     public List<UserModel> fetchOneData(@PathVariable String name) {
      return userService.fetchOneData(name);
     }

    @JsonView(Views.Public.class)
      @GetMapping("/users")
         public List<UserModel> fetchAllData(){
             return userService.fetchAllData();
    }
        //step6
        //@JsonView(Views.Internal.class)
       @PutMapping("/users/{uId}/{aId}")
       public Optional<UserModel> fetchAdd(@PathVariable Integer uId, @PathVariable Integer aId)
          {

              return userService.fetchAdd(uId,aId);
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





