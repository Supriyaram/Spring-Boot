package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //@Column(name = "id")
        private Long id;
        private String name;
        private String email;
        private String phn;

       // @OneToMany(mappedBy = "user")
        //private Set<Address> address;


}
