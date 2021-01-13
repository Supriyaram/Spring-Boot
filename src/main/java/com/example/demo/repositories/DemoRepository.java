package com.example.demo.repositories;

import com.example.demo.models.Address;
import com.example.demo.models.DemoModel;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository  extends JpaRepository<User,Integer> {
}
