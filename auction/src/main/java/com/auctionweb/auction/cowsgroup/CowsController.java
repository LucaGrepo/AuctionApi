package com.auctionweb.auction.cowsgroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CowsController {

    @Autowired
    private CowsService cowsServ;

    @GetMapping("/getAllGroups")
    public List<CowsGroup> CattleList(){//show a list of all groups
        return cowsServ.getAllGroups();
    }

    @PostMapping("/submitCattle")
    public CowsGroup postCattle(@RequestBody CowsGroup cg) {
        return cowsServ.postGroup(cg);
    }
    
}
