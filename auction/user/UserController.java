package com.auctionweb.auction.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//spring security will be in charge of displaying the login UI
//for the register UI will be implemented by myself.

@Controller
public class UserController {

    @Autowired
    private UserServ uServ;

    @GetMapping("/userRegister")
    public String userRegister(Model model){ //the data is loaded and...
        return "userRegister";
    }

    @PostMapping("/postRegister")
    public String postUserRegister(@RequestParam String name,
                                 @RequestParam String password){ //is sent to this endpoint that handles POST method and saves to DB.
        uServ.postUserWithParams(name, password);
        System.out.println("HOOOLLAA");
        return "home";
    }
}
