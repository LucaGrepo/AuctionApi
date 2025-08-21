package com.auctionweb.auction.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
    public User findUserById(Long id);
    public void deleteUserById(Long id);
    public User findUserByName(String username);
}
