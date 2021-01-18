package com.example.demo.services;


import com.example.demo.models.AddressModel;
import com.example.demo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    public AddressRepository addressRepository;

    public  List<AddressModel> fetchAData(String street) {
        return  addressRepository.findByAName(street);
    }

    public AddressModel addData(AddressModel address)
    {
        return addressRepository.save(address);

    }
  public List<AddressModel> fetchData()
  {
      return addressRepository.findAll();
  }

  //  public List<Address> fetchAdd(Integer u_id){
    //    return secRepository.findByAName(u_id);
    //}

}
