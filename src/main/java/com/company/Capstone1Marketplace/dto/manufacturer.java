package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "manufacturer")

public class manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer manufacturerId;

    @NotNull
    @NotEmpty
    private String manufacturerName;

    @NotNull
    @NotEmpty
    private String manufacturerStreet;

    @NotNull
    @NotEmpty
    private String manufacturerCity;

    @NotNull
    @NotEmpty
    @Size(min=2, max=2, message="Please use your state's 2-letter abbreviation only.")
    private String manufacturerState;

    @NotNull
    @NotEmpty
    @Size(min=5, max=5, message="Zip Code must be exactly 5 digits")
    private String manufacturerZipCode;

    @NotNull
    @NotEmpty
    private String manufacturerPhone;

    @NotNull
    @NotEmpty
    private String manufacturerContact;

    @OneToMany(mappedBy="manu", cascade=CascadeType.ALL, fetch=FetchType.EAGER)


    //GETSET

    public Integer getManufacturerId() {return this.manufacturerId;}
    public void setManufacturerId(Integer manufacturerId) {this.manufacturerId = manufacturerId;}

    public String getManufacturerName() {return this.manufacturerName;}
    public void setManufacturerName(String manufacturerName) {this.manufacturerName = manufacturerName;}

    public String getManufacturerStreet() {return this.manufacturerStreet;}
    public void setManufacturerStreet(String manufacturerStreet) {this.manufacturerStreet = manufacturerStreet;}

    public String getManufacturerCity() {return this.manufacturerCity;}
    public void setManufacturerCity(String manufacturerCity) {this.manufacturerCity = manufacturerCity;}

    public String getManufacturerState() {return this.manufacturerState;}
    public void setManufacturerState(String manufacturerState) {this.manufacturerState = manufacturerState;}

    public String getManufacturerZipCode() {return this.manufacturerZipCode;}
    public void setManufacturerZipCode(String manufacturerZipCode) {this.manufacturerZipCode = manufacturerZipCode;}

    public String getManufacturerPhone() {return this.manufacturerPhone;}
    public void setManufacturerPhone(String manufacturerPhone) {this.manufacturerPhone = manufacturerPhone;}

    public String getManufacturerContact() {return this.manufacturerContact;}
    public void setManufacturerContact(String manufacturerContact) {this.manufacturerContact = manufacturerContact;}





}
