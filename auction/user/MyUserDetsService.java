package com.auctionweb.auction.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Defines how to fetch user data by username (or email, etc.) from the source (DB, LDAP, API).

@Service
public class MyUserDetsService implements UserDetailsService {

    @Autowired
    private UserRep ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = ur.findUserByName(username);
        if(user == null){
            System.out.println("user does not exists");
            throw new UsernameNotFoundException("err");
        }

        return new UserPrincipal(user);
    }

}
