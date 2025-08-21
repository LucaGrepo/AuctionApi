package com.auctionweb.auction.farm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRep extends JpaRepository<Farm, Long>{
    public Farm findFarmById(Long id);
    public void deleteFarmById(Long id);
}
