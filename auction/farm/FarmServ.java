package com.auctionweb.auction.farm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FarmServ {

    @Autowired
    private FarmRep fRep;


    public List<Farm> getAll(){
        return fRep.findAll();
    }

    public Farm getOne(Long id){
        return fRep.findFarmById(id);
    }

    public void delFarm(Long id){
        fRep.deleteFarmById(id);
    }

    public Farm postFarm(Farm farm){
        return fRep.saveAndFlush(farm);
    }

}
