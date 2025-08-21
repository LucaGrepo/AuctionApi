package com.auctionweb.auction.cowsgroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CowsService {

    @Autowired
    private CowsRep cRep;

    public CowsGroup getGroup(Long id){
        return cRep.findGroupById(id);
    }

    public List<CowsGroup> getAllGroups(){
        return cRep.findAll();
    }

    public CowsGroup postGroup(CowsGroup cg){
        return cRep.saveAndFlush(cg);
    }

    public void delGroup(Long id){
        cRep.deleteCow_groupsById(id);
    }
}
