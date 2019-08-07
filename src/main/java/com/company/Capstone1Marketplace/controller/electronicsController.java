package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.electronics;
import com.company.Capstone1Marketplace.service.electronicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/electronics")
public class electronicsController {

    @Autowired
    private electronicsService service;

    //ADDS ELECTRONICS TO TABLE BY ID
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public electronics addElectronics(@RequestBody @Valid electronics elec) {
        return service.addElectronics(elec);
    }

    //GETS ENTIRE LIST OF ELECTRONICS
    @GetMapping
    public List<electronics> getAllElectronics() {
        return service.getAllElectronics();
    }

    // GETS ELECTRONICS BY ID
    @GetMapping(value="/id/{electronicsId}")
    public electronics getElectronicsById(@PathVariable Integer electronicsId) {
        return (electronics) service.getElectronicsById(electronicsId);
    }

    //GETS ELECTRONICS BY NAME
    @GetMapping(value="/name/{electronicsName}")
    public List<electronics> getElectronicsByName(@PathVariable String electronicsName) {
        return service.getElectronicsByName(electronicsName);
    }

    //GETS ELECTRONICS BY PRICE
    @GetMapping(value="/price/{electronicsPrice}")
    public List<electronics> getElectronicsByPrice(@PathVariable Double electronicsPrice) {
        return service.getElectronicsByPrice(electronicsPrice);
    }

    //GETS ELECTRONICS BY QUANTITY AMOUNT
    @GetMapping(value="/quantity/{electronicsQuantity}")
    public List<electronics> getElectronicsByQuantity(@PathVariable Integer electronicsQuantity) {
        return service.getElectronicsByQuantity(electronicsQuantity);
    }

    //GETS ELECTRONICS BY RATING - POSSIBLE LIST IF ANY ENTRIES MATCH
    @GetMapping(value="/rate/{electronicsRating}")
    public List<electronics> getElectronicsByRating(@PathVariable Integer electronicsRating) {
        return service.getElectronicsByRating(electronicsRating);
    }

    //GETS ELECTRONICS RATED ABOVE A 4
    @GetMapping(value="/bestreview")
    public List<electronics> getElectronicsRatedAbove4(@PathVariable Integer electronicsRating) {
        return service.getElectronicsRatedAbove4(electronicsRating);
    }

    //PUT METHOD UPDATES ELECTRONICS BY ID
    @PutMapping(value="/update/{electronicsID}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateElectronics(@PathVariable @Valid electronics elec, Integer electronicsId) {
        service.updateElectronics(elec, electronicsId);
    }

    //DELETE METHOD DELETES ELECTRONICS FROM TABLE BY ID
    @DeleteMapping(value="/delete/{electronicsId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteElectronics(@PathVariable Integer electronicsId) {
        service.deleteElectronics(electronicsId);
    }






}
