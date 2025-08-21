package com.auctionweb.auction.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//The user entity will be another table in the database that helps with registering and login in the page.
//this table will have a foreign key attached to the farm table. So each user can have one farm, and that farm
//can have multiple cattle groups submitted.

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String name;
    private String password;

    public Long getId(){
        return user_id;
    }

    public void setId(Long user_id){
        this.user_id = user_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
