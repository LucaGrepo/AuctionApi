package com.auctionweb.auction.farm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auctionweb.auction.cowsgroup.CowsGroup;
import com.auctionweb.auction.cowsgroup.CowsRep;

@RestController
public class FarmController {

    @Autowired
    private FarmServ farmServ;

    @Autowired
    private CowsRep cRep;

    @GetMapping("/getAllFarms")
    public List<Farm> getAllFarms(){
        return farmServ.getAll();
    }

    @GetMapping("/getFarm/{id}")
    public Farm getFarm(@PathVariable Long id){
        return farmServ.getOne(id);
    }

    @GetMapping("/getFarmFromCattle/{cattle_id}")
    public Farm getFarmFromCattle(@PathVariable Long cattle_id){
        CowsGroup group = cRep.findGroupById(cattle_id);
        return group.getFarm();
    }

    @PostMapping("/postFarm")
    public Farm postFarm(@RequestBody Farm farm){ //this endpoint will be protected by login page, quizas modificar
        return farmServ.postFarm(farm);           //modificar el login UI para que incluya un link para registrarse
    }
}
