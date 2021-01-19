package com.example.demo.services;



import com.example.demo.models.AuthorsModel;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    public AuthorRepository authorRepository;

    public  List<AuthorsModel> fetchAData(String name) {

        return  authorRepository.findByAName(name);
    }

    public AuthorsModel addData(AuthorsModel authorsModel)
    {
        return authorRepository.save(authorsModel);

    }
    public List<AuthorsModel> fetchData()
    {
        return authorRepository.findAll();
    }

    //  public List<Address> fetchAdd(Integer u_id){
    //    return secRepository.findByAName(u_id);
    //}

}
