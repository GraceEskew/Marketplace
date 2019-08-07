package com.company.Capstone1Marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "accessories")

public class accessories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accessoriesId;

    @NotNull
    private String accessoriesName;

    @NotNull
    private Double accessoriesPrice;

    @NotNull
    private Integer accessoriesQuantity;

    @NotNull
    @Size(min=1, max=1, message="Rating must be exactly 1 digit")
    private Integer accessoriesRating;


    //JOIN - THINKING OF REMOVING THE JOIN HERE, AND IMPLEMENTING IT ONCE I HAVE THE INVOICE CLASS BUILT TO HELP
    // LINK MANUFACTURER INFORMATION TO PRODUCTS & INVOICES
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manufacturerId")
    private manufacturer manu;

    // GETSET
    public Integer getAccessoriesId() {return this.accessoriesId;}
    public void setAccessoriesId(Integer accessoriesId) {this.accessoriesId = accessoriesId;}

    public String getAccessoriesName() {return this.accessoriesName;}
    public void setAccessoriesName(String accessoriesName) {this.accessoriesName = accessoriesName;}

    public Double getAccessoriesPrice() {return this.accessoriesPrice;}
    public void setAccessoriesPrice(Double accessoriesPrice) {this.accessoriesPrice = accessoriesPrice;}

    public Integer getAccessoriesQuantity() {return this.accessoriesQuantity;}
    public void setAccessoriesQuantity(Integer accessoriesQuantity) {this.accessoriesQuantity = accessoriesQuantity;}

    public Integer getAccessoriesRating() {return this.accessoriesRating;}
    public void setAccessoriesRating(Integer accessoriesRating) {this.accessoriesRating = accessoriesRating;}

    public manufacturer getManu() {return this.manu;}
    public void setManu(manufacturer manu) {this.manu = manu;}

}

/*Notes__________________
 * 1. Likely will retool to have manufacturer data linked with products and invoices. Next time - need to manage time better.
 *      Initial DAO Tests  ate a lot of useful time.
 *
 *
 * */
