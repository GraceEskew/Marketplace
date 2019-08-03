package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "garden")

public class garden {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gardenId;

    @NotNull
    @NotEmpty
    private String gardenName;

    @NotNull
    @NotEmpty
    private Double gardenPrice;

    @NotNull
    @NotEmpty
    private Integer gardenQuantity;

    @NotNull
    @NotEmpty
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer gardenRating;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manufacturerId")
    private manufacturer manu;


    //GETSET

    public Integer getGardenId() {return this.gardenId;}
    public void setGardenId(Integer gardenId) {this.gardenId = gardenId;}

    public String getGardenName() {return this.gardenName;}
    public void setGardenName(String gardenName) {this.gardenName = gardenName;}

    public Double getGardenPrice() {return this.gardenPrice;}
    public void setGardenPrice(Double gardenPrice) {this.gardenPrice = gardenPrice;}

    public Integer getGardenQuantity() {return this.gardenQuantity;}
    public void setGardenQuantity(Integer gardenQuantity) {this.gardenQuantity = gardenQuantity;}

    public Integer getGardenRating() {return this.gardenRating;}
    public void setGardenRating(Integer gardenRating) {this.gardenRating = gardenRating;}

    public manufacturer getManu() {return this.manu;}
    public void setManu(manufacturer manu) {this.manu = manu;}
}
