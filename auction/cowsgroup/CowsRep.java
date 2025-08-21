package com.auctionweb.auction.cowsgroup;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CowsRep extends JpaRepository<CowsGroup, Long> {
    public CowsGroup findGroupById(Long id);
    
    public void deleteCow_groupsById(Long id);
}
