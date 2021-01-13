package com.example.demo.controller;

import com.example.demo.models.Address;
import com.example.demo.models.DemoModel;
import com.example.demo.models.User;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    public DemoService demoService;


    @PostMapping("/address")
    public User addData(@RequestBody User user) {

        return demoService.addData(user);
    }



     @GetMapping("/address")
     public List<User> fetchAllData(){
         return demoService.fetchAllData();

    }
   //@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    //public void updateData(@RequestBody DemoModel demoModel,@PathVariable Integer id){
         //demoService.updateModel(demoModel,id);
    //}

}
