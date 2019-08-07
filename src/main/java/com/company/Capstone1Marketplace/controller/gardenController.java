package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.garden;
import com.company.Capstone1Marketplace.service.gardensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/garden")
public class gardenController {
    @Autowired
    private gardensService service;

    //ADDS GARDEN TO TABLE BY ID
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public garden addGarden(@RequestBody @Valid garden gar) {
        return service.addGarden(gar);
    }

    //GETS ENTIRE LIST OF CURRENT GARDEN PRODUCTS
    @GetMapping
    public List<garden> getAllGardens() {
        return service.getAllGardens();
    }

    //GETS GARDEN ENTRY BY ID
    @GetMapping(value="/id/{gardenId}")
    public garden getGardenById(@PathVariable Integer gardenId) {
        return (garden) service.getGardenById(gardenId);
    }

    //GETS GARDEN BY NAME
    @GetMapping(value="/name/{gardenName}")
    public List<garden> getGardenByName(@PathVariable String gardenName) {
        return service.getGardenByName(gardenName);
    }

    //GETS GARDEN ENTRIES BY PRICE - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/price/{gardenPrice}")
    public List<garden> getGardenByPrice(@PathVariable Double gardenPrice) {
        return service.getGardenByPrice(gardenPrice);
    }

    //GETS GARDEN ENTRIES BY QUANTITY COUNT - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/quantity/{gardenQuantity}")
    public List<garden> getGardenByQuantity(@PathVariable Integer gardenQuantity) {
        return service.getGardenByQuantity(gardenQuantity);
    }

    //GETS GARDEN ENTRIES BY CUSTOMER RATING - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/rate/{gardenRating}")
    public List<garden> getGardenByRating(@PathVariable Integer gardenRating) {
        return service.getGardenByRating(gardenRating);
    }

    //GETS GARDEN ENTRIES RATED ABOVE 4
    @GetMapping(value="/bestreview")
    public List<garden> getGardenRatedAbove4(@PathVariable Integer gardenRating) {
        return service.getGardensRatedAbove4(gardenRating);
    }

    //UPDATES GARDEN ENTRY VIA ID
    @PutMapping(value="/update/{gardenId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGarden(@PathVariable @Valid garden gar, Integer gardenId) {
        service.updateGarden(gar, gardenId);
    }

    //DELETES GARDEN ENTRY FROM TABLE VIA ID
    @DeleteMapping(value="/delete/{gardenId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGarden(@PathVariable Integer gardenId) {
        service.deleteGarden(gardenId);
    }




}
