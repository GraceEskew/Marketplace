package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "beauty")

public class beauty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer beautyId;

    @NotNull
    @NotEmpty
    private String beautyName;

    @NotNull
    @NotEmpty
    private Double beautyPrice;

    @NotNull
    @NotEmpty
    private Integer beautyQuantity;

    @NotNull
    @NotEmpty
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer beautyRating;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manufacturerId")
    private manufacturer manu;


    //GETSET
    public Integer getBeautyId() {return this.beautyId;}
    public void setBeautyId(Integer beautyId) {this.beautyId = beautyId;}

    public String getBeautyName() {return this.beautyName;}
    public void setBeautyName(String beautyName) {this.beautyName = beautyName;}

    public Double getBeautyPrice() {return this.beautyPrice;}
    public void setBeautyPrice(Double beautyPrice) {this.beautyPrice = beautyPrice;}

    public Integer getBeautyQuantity() {return this.beautyQuantity;}
    public void setBeautyQuantity(Integer beautyQuantity) {this.beautyQuantity = beautyQuantity;}

    public Integer getBeautyRating() {return this.beautyRating;}
    public void setBeautyRating(Integer beautyRating) {this.beautyRating = beautyRating;}

    public manufacturer getManu() {return this.manu;}
    public void setManu(manufacturer manu) {this.manu = manu;}
}
