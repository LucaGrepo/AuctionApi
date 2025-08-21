package com.auctionweb.auction.cowsgroup;

import com.auctionweb.auction.farm.Farm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//note: its understood that the fields for the cattle caracteristics are an AVERAGE of it. this is so i dont have to put "avg" in names.

@Entity
@Table(name = "cow_groups")
public class CowsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;

    private String breed;
    private Integer amount;

    private Integer frame;
    private Float body_length;
    private Float body_width;
    private Float head_width;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farmOwner;


    public Long getId() {
        return group_id;
    }

    public void setId(Long group_id) {
        this.group_id = group_id;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public Integer getAmount(){
        return amount;
    }

    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public Integer getFrame() {
        return frame;
    }

    public void setFrame(Integer frame) {
        this.frame = frame;
    }

    public Float getBodyLength() {
        return body_length;
    }

    public void setBodyLength(Float body_length) {
        this.body_length = body_length;
    }

    public Float getBodyWidth() {
        return body_width;
    }

    public void setBodyWidth(Float body_width) {
        this.body_width = body_width;
    }

    public Float getHeadWidth() {
        return head_width;
    }

    public void setHeadWidth(Float head_width) {
        this.head_width = head_width;
    }

    public Farm getFarm() {
        return farmOwner;
    }

    public void setFarm(Farm farmOwner) {
        this.farmOwner = farmOwner;
    }
}
