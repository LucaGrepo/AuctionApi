package com.auctionweb.auction.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServ {

    @Autowired
    private UserRep uRep;

    @Autowired
    private PasswordEncoder passEnc;

    public List<User> getUsers(){
        return uRep.findAll();
    }

    public User getUserById(Long id){
        return uRep.findUserById(id);
    }

    public User postUser(User user){
        return uRep.saveAndFlush(user);
    }

    public User postUserWithParams(String name, String password){
        User u = new User();
        u.setName(name);
        u.setPassword(passEnc.encode(password));
        return uRep.save(u);
    }

    public void delUser(Long id){ //maybe change it to delete after writting the password
        uRep.deleteUserById(id);
    }

    //ill write the PUT method later...
}
