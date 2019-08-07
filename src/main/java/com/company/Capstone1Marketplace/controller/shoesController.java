package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.shoes;
import com.company.Capstone1Marketplace.service.shoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/shoes")
public class shoesController {
    @Autowired
    shoesService service;

    //ADDS SHOES ENTRY TO TABLE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public shoes addShoes(@RequestBody @Valid shoes sole) {
        return service.addShoes(sole);
    }

    //GETS CURRENT LIST OF ALL SHOES
    @GetMapping
    public List<shoes> getShoes() {
        return service.getAllShoes();
    }

    //GETS SHOES VIA ID
    @GetMapping(value="/id/{shoesId}")
    public shoes getShoesById(@PathVariable Integer shoesId) {
        return (shoes) service.getShoesById(shoesId);
    }

    //GET SHOES VIA NAME
    @GetMapping(value="name/{shoesName}")
    public List<shoes> getShoesByName(@PathVariable String shoesName) {
        return service.getShoesByName(shoesName);
    }

    //GET SHOES VIA PRICE - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/price/{shoesPrice}")
    public List<shoes> getShoesByPrice(@PathVariable Double shoesPrice) {
        return service.getShoesByPrice(shoesPrice);
    }

    //GET SHOES VIA QUANTITY - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/quantity/{shoesQuantity}")
    public List<shoes> getShoesByQuantity(@PathVariable Integer shoesQuantity) {
        return service.getShoesByQuantity(shoesQuantity);
    }

    //GET SHOES VIA CUSTOMER RATING - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/rate/{shoesRating}")
    public List<shoes> getShoesByRating(@PathVariable Integer shoesRating){
        return service.getShoesByRating(shoesRating);
    }

    //GET SHOES RATED ABOVE 4 - WORK IN PROGRESS
    @GetMapping(value="/bestreview")
    public List<shoes> getShoesRatedAbove4(@PathVariable Integer shoesRating) {
        return service.getShoesRatedAbove4(shoesRating);
    }

    //UPDATE SHOES VIA ID
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateShoes(@RequestBody @Valid shoes sole, @PathVariable Integer shoesId){
        service.updateShoes(sole, shoesId);
    }

    //DELETES SHOE ENTRY FROM TABLE VIA ID
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShoes(@PathVariable Integer shoesId) {
        service.deleteShoes(shoesId);
    }
}

/*Notes________________
* Working on correctly implementing Objects rated above 4. Will move onto sorting prices
* .sort (collections) seems to be the quickest route. It defaults to ascending order, and when added
* with a reverse tag, you can get descending. Time is tight, but try your best.
*
* */
