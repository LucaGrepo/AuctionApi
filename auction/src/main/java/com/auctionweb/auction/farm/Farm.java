package com.auctionweb.auction.farm;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farms")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farm_id;
    private String brand;
    private Integer founding_year;
    private String email;


    public Long getId() {
        return farm_id;
    }

    public void setId(Long farm_id) {
        this.farm_id = farm_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getFoundingYear() {
        return founding_year;
    }

    public void setFoundingYear(Integer founding_year) {
        this.founding_year = founding_year;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
