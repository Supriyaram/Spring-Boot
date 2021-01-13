package com.example.demo.services;

import com.example.demo.models.Address;
import com.example.demo.models.DemoModel;
import com.example.demo.models.User;
import com.example.demo.repositories.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    @Autowired
    public  DemoRepository demoRepository;

    public  User addData(User user){
        return demoRepository.save(user);

    }



    public List<User> fetchAllData()
    {

        return demoRepository.findAll();


    }

        }

