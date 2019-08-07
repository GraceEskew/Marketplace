package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.beauty;
import com.company.Capstone1Marketplace.service.beautyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/beauty")
public class beautyController {

    @Autowired
    private beautyService beauService;


    //ADDS BEAUTY ENTRY TO TABLE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public beauty addBeauty(@RequestBody @Valid beauty beau) {
        return beauService.addBeauty(beau);
    }

    //GETS CURRENT LIST OF BEAUTY PRODUCTS
    @GetMapping
    public List<beauty> getAllBeauty() {
        return beauService.getAllBeauty();
    }

    //GETS BEAUTY ENTRY VIA ID
    @GetMapping(value="/id/{beautyId}")
    public beauty getBeautyById(@PathVariable Integer beautyId) {return beauService.getBeautyById(beautyId);}

    //GETS BEAUTY ENTRY VIA NAME
    @GetMapping(value="/name/{beautyName}")
    public List<beauty> getBeautyByName(@PathVariable String beautyName) {return beauService.getBeautyByName(beautyName);}

    //GETS BEAUTY ENTRY VIA PRICE
    @GetMapping(value="/price/{beautyPrice}")
    public List<beauty> getBeautyByPrice(@PathVariable Double beautyPrice) {
        return beauService.getBeautyByPrice(beautyPrice);
    }

    //GETS BEAUTY ENTRY VIA QUANTITY - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/quantity/{beautyQuantity}")
    public List<beauty> getBeautyByQuantity(@PathVariable Integer beautyQuantity) {return beauService.getBeautyByQuantity(beautyQuantity);}

    //GETS BEAUTY ENTRY VIA CUSTOMER RATING - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/rate/{beautyRating}")
    public List<beauty> getBeautyByRating(@PathVariable Integer beautyRating) {return beauService.getBeautyByRating(beautyRating);}



    // UPDATES BEAUTY ENTRY IN TABLE VIA ID
    @PutMapping(value="/update/{beautyId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateBeauty(@RequestBody @Valid beauty beau, @PathVariable Integer beautyId) {
        beauService.updateBeauty(beau, beautyId);
    }

    //DELETES BEAUTY ENTRY VIA ID
    @DeleteMapping(value="/delete/{beautyId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteBeauty(@PathVariable Integer beautyId) {
        beauService.deleteBeauty(beautyId);
    }

}
