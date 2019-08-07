package com.company.Capstone1Marketplace.controller;

import com.company.Capstone1Marketplace.dto.home;
import com.company.Capstone1Marketplace.service.homeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/home")
public class homeController {
    @Autowired
    homeService service;

    //ADDS HOME ENTRY TO TABLE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public home addHome(@RequestBody @Valid home casa) {
        return service.addHome(casa);
    }

    //GETS CURRENT LIST OF HOMES
    @GetMapping
    public List<home> getAllHome() {
        return service.getAllHome();
    }

    //GETS HOME PRODUCTS VIA ID
    @GetMapping(value="/id/{homeId}")
    public home getHomeById(@PathVariable Integer homeId) {
        return (home) service.getHomeById(homeId);
    }

    //GETS HOME PRODUCTS VIA NAME
    @GetMapping(value="/name/{homeName}")
    public List<home> getHomeByName(@PathVariable String homeName) {
        return service.getHomeByName(homeName);
    }

    //GETS HOME PRODUCTS VIA PRICE - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/price/{homePrice}")
    public List<home> getHomeByPrice(@PathVariable Double homePrice){
        return service.getHomeByPrice(homePrice);
    }

    //GETS HOME PRODUCTS VIA QUANTITY - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/quantity/{homeQuantity}")
    public List<home> getHomeByQuantity(@PathVariable Integer homeQuantity) {
        return service.getHomeByQuantity(homeQuantity);
    }

    //GETS HOME PRODUCTS VIA CUSTOMER RATING - POSSIBLE LIST IF ENTRIES MATCH
    @GetMapping(value="/rate/{homeRating}")
    public List<home> getHomeByRating(@PathVariable Integer homeRating) {
        return service.getHomeByRating(homeRating);
    }

    //GETS HOME PRODUCTS RATED ABOVE 4 - work in progress
    @GetMapping(value="/bestreview")
    public List<home> getHomeRatedAbove4(@PathVariable Integer homeRating) {
        return service.getHomesRatedAbove4(homeRating);
    }

    //UPDATES A HOME PRODUCT ENTRY VIA ID
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHome(@RequestBody @Valid home casa, @PathVariable Integer homeId) {
        service.updateHome(casa, homeId);
    }

    //DELETES A HOME PRODUCT ENTRY VIA ID
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHome(@PathVariable Integer homeId) {
        service.deleteHome(homeId);
    }

}
