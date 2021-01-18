package com.example.demo.services;

import com.example.demo.models.AddressModel;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.AddressRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserModel addData(UserModel user) {
        return userRepository.save(user);

    }

    public List<UserModel> fetchAllData() {

        return userRepository.findAll();


    }

    public List<UserModel> fetchOneData(String name) {
        //System.out.println(name);
        return userRepository.findByName(name);

    }

    public Optional<UserModel> fetchAdd(Integer uId, Integer aId) {
        System.out.println("uid:"+uId);
        System.out.println("aId: "+aId);
         if(userRepository.findById(uId).isPresent()){
             System.out.println("user object present");
         }
        UserModel user = userRepository.findById(uId).get();
         // System.out.println(user);
        AddressModel addresses = addressRepository.findById(aId).get();
        List<AddressModel> addressList = new ArrayList<AddressModel>();

        addressList.add(addresses);

        addresses.setUser(user);
        user.setAddress(addressList);
        userRepository.save(user);
        addressRepository.save(addresses);


        return null;


        //public UserRequest saveUser(UserRequest userRequest) {
        //  return demoRepository.save(userRequest);

        //}
    }
}

