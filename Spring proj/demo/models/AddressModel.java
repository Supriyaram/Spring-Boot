package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
    public class AddressModel {

       @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
       @JsonView(Views.Public.class)
        public Integer id;

       @JsonView(Views.Public.class)
       public String street;


        @ManyToOne
        @JoinColumn
        @JsonView(Views.Internal.class)
        private UserModel user;


    }

