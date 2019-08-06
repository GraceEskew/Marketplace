package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "apparel")
public class apparel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer apparelId;

    @NotNull
    private String apparelName;

    @NotNull
    private Double apparelPrice;

    @NotNull
    private Integer apparelQuantity;

    @NotNull
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer apparelRating;

//    @ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="manufacturerId")
//    private manufacturer manuf;


    //GETSET

    public Integer getApparelId() {return this.apparelId;}
    public void setApparelId(Integer apparelId) {this.apparelId = apparelId;}

    public String getApparelName() {return this.apparelName;}
    public void setApparelName(String apparelName) {this.apparelName = apparelName;}

    public Double getApparelPrice() {return this.apparelPrice;}
    public void setApparelPrice(Double apparelPrice) {this.apparelPrice = apparelPrice;}

    public Integer getApparelQuantity() {return this.apparelQuantity;}
    public void setApparelQuantity(Integer apparelQuantity) {this.apparelQuantity = apparelQuantity;}

    public Integer getApparelRating() {return this.apparelRating;}
    public void setApparelRating(Integer apparelRating) {this.apparelRating = apparelRating;}

//    public manufacturer getManuf() {return this.manuf;}
//    public void setManuf(manufacturer manuf) {this.manuf = manuf;}
//
//    public manufacturer getManu() {return this.manuf;}
//    public void setManuf(manufacturer manuf) {this.manuf = manuf;}

}
