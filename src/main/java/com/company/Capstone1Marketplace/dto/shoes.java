package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "shoes")

public class shoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shoesId;

    @NotNull

    private String shoesName;

    @NotNull
    private Double shoesPrice;

    @NotNull
    private Integer shoesQuantity;

    @NotNull
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer shoesRating;

//    @ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="manufacturerId")
//    private manufacturer manu;


    //GETSET

    public Integer getShoesId() {return this.shoesId;}
    public void setShoesId(Integer shoesId) {this.shoesId = shoesId;}

    public String getShoesName() {return this.shoesName;}
    public void setShoesName(String shoesName) {this.shoesName = shoesName;}

    public Double getShoesPrice() {return this.shoesPrice;}
    public void setShoesPrice(Double shoesPrice) {this.shoesPrice = shoesPrice;}

    public Integer getShoesQuantity() {return this.shoesQuantity;}
    public void setShoesQuantity(Integer shoesQuantity) {this.shoesQuantity = shoesQuantity;}

    public Integer getShoesRating() {return this.shoesRating;}
    public void setShoesRating(Integer shoesRating) {this.shoesRating = shoesRating;}

//    public manufacturer getManu() {return this.manu;}
//    public void setManu(manufacturer manu) {this.manu = manu;}
}
