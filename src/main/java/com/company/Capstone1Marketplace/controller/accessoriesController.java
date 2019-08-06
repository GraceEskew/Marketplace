package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.accessories;
import com.company.Capstone1Marketplace.service.accessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/accessories")
public class accessoriesController {

    @Autowired
    private accessoriesService service;

    @PostMapping
    @ResponseStatus(value= HttpStatus.CREATED)
    public accessories addAccessories(@RequestBody @Valid accessories access) {
        return service.addAccessories(access);
    }

    @GetMapping
    public List<accessories> getAllAccessories() {
        return service.getAllAccessories();
    }

    @GetMapping(value="/{accessoriesId}")
    public accessories getAccessoriesById(@PathVariable Integer accessoriesId) {
        return (accessories) service.getAccessoriesById(accessoriesId);
    }

    @GetMapping(value="/{accessoriesName}")
    public List<accessories> getAccessoriesByName(@PathVariable String accessoriesName) {
        return service.getAccessoriesByName(accessoriesName);
    }

    @GetMapping(value="/{accessoriesPrice}")
    public List<accessories> getAccessoriesByPrice(@PathVariable Double accessoriesPrice) {
        return service.getAccessoriesByPrice(accessoriesPrice);
    }

    @GetMapping(value="/{accessoriesQuantity}")
    public List<accessories> getAccessoriesByQuantity(@PathVariable Integer accessoriesQuantity) {
        return service.getAccessoriesByQuantity(accessoriesQuantity);
    }

    @GetMapping(value="/{accessoriesRating}")
    public List<accessories> getAccessoriesByRating(@PathVariable Integer accessoriesRating) {
        return service.getAccessoriesByRating(accessoriesRating);
    }

    @PutMapping(value="/{accessoriesId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateAccessories(@RequestBody @Valid accessories access, @PathVariable Integer accessoriesId) {
        service.updateAccessories(access, accessoriesId);
    }

    @DeleteMapping(value="/{accessoriesId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteAccessories(@PathVariable Integer accessoriesId) {
        service.deleteAccessories(accessoriesId);
    }



}
