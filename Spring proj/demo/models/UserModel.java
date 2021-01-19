package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
    public class UserModel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        @JsonView(Views.Public.class)
        private Integer id;

        @JsonView(Views.Public.class)
        private String name;
        //private String email;
        //private String phn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer u_id) {
        this.id = u_id;
    }

    public void setAddress(List<AddressModel> address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressModel> getAddress() {
        return address;
    }



    @OneToMany(mappedBy = "user")
    @JsonView(Views.Public.class)
    private List<AddressModel> address;

}
