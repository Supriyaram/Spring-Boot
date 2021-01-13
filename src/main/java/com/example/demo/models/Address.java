package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;


    @Data
    @Entity
    @Table(name = "Address")
    public class Address {


       @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;
       private String street;


        @ManyToOne
        @JoinColumn(nullable = false)
        private User user;

        public Address(){

        }

    }

