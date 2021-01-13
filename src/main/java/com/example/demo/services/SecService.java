package com.example.demo.services;


import com.example.demo.models.Address;
import com.example.demo.repositories.SecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecService {
    @Autowired
    public SecRepository secRepository;

    public Address addData(Address address)
    {
        return secRepository.save(address);

    }
  public Optional<Address> fetchAllData()
  {
      return secRepository.findOne();
  }

}
