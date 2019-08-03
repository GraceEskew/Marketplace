package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "home")

public class home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer homeId;

    @NotNull
    @NotEmpty
    private String homeName;

    @NotNull
    @NotEmpty
    private Double homePrice;

    @NotNull
    @NotEmpty
    private Integer homeQuantity;

    @NotNull
    @NotEmpty
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer homeRating;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manufacturerId")
    private manufacturer manu;


    //GETSET

    public Integer getHomeId() {return this.homeId;}
    public void setHomeId(Integer homeId) {this.homeId = homeId;}

    public String getHomeName() {return this.homeName;}
    public void setHomeName(String homeName) {this.homeName = homeName;}

    public Double getHomePrice() {return this.homePrice;}
    public void setHomePrice(Double homePrice) {this.homePrice = homePrice;}

    public Integer getHomeQuantity() {return this.homeQuantity;}
    public void setHomeQuantity(Integer homeQuantity) {this.homeQuantity = homeQuantity;}

    public Integer getHomeRating() {return this.homeRating;}
    public void setHomeRating(Integer homeRating) {this.homeRating = homeRating;}

    public manufacturer getManu() {return this.manu;}
    public void setManu(manufacturer manu) {this.manu = manu;}
}
