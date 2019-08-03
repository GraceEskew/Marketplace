package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "electronics")

public class electronics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer electronicsId;

    @NotNull
    @NotEmpty
    private String electronicsName;

    @NotNull
    @NotEmpty
    private Double electronicsPrice;

    @NotNull
    @NotEmpty
    private Integer electronicsQuantity;

    @NotNull
    @NotEmpty
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer electronicsRating;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manufacturerId")
    private manufacturer manu;


    //GETSET
    public Integer getElectronicsId() {return this.electronicsId;}
    public void setElectronicsId(Integer electronicsId) {this.electronicsId = electronicsId;}

    public String getElectronicsName() {return this.electronicsName;}
    public void setElectronicsName(String electronicsName) {this.electronicsName = electronicsName;}

    public Double getElectronicsPrice() {return this.electronicsPrice;}
    public void setElectronicsPrice(Double electronicsPrice) {this.electronicsPrice = electronicsPrice;}

    public Integer getElectronicsQuantity() {return this.electronicsQuantity;}
    public void setElectronicsQuantity(Integer electronicsQuantity) {this.electronicsQuantity = electronicsQuantity;}

    public Integer getElectronicsRating() {return this.electronicsRating;}
    public void setElectronicsRating(Integer electronicsRating) {this.electronicsRating = electronicsRating;}

    public manufacturer getManu() {return this.manu;}
    public void setManu(manufacturer manu) {this.manu = manu;}
}
