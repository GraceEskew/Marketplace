package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.accessories;
import com.company.Capstone1Marketplace.service.accessoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/accessories")
public class accessoriesController {

    @Autowired
    private accessoriesService service;


    //POST http://localhost:8080/accessories/
    //Current Status: error 400; bad request. SON parse error: Cannot deserialize instance. Reviewing
    @PostMapping
    @ResponseStatus(value= HttpStatus.CREATED)
    public accessories addAccessories(@RequestBody @Valid accessories access) {
        return service.addAccessories(access);
    }

    //GET  http://localhost:8080/accessories -- gets entire list of accessories
    @GetMapping
    public List<accessories> getAllAccessories() {
        return service.getAllAccessories();
    }



    //GET http://localhost:8080/accessories/ID/{user's input: product ID}
    // returns product information via ID number
    @GetMapping(value="/ID/{accessoriesId}")
    public accessories getAccessoriesById(@PathVariable Integer accessoriesId) {
        return (accessories) service.getAccessoriesById(accessoriesId);
    }



    //GET http://localhost:8080/accessories/Name/{user's input: product name }
    // returns product information via ID number
    @GetMapping(value="/Name/{accessoriesName}")
    public List<accessories> getAccessoriesByName(@PathVariable String accessoriesName) {
        return service.getAccessoriesByName(accessoriesName);
    }


    //GET http://localhost:8080/accessories/Price/{user's input: product price}
    // returns all products set at that specific price
    @GetMapping(value="/Price/{accessoriesPrice}")
    public List<accessories> getAccessoriesByPrice(@PathVariable Double accessoriesPrice) {
        return service.getAccessoriesByPrice(accessoriesPrice);
    }


    //GET http://localhost:8080/accessories/Quantity/{user's input: Number of products}
    // returns all products with the matching quantity number
    @GetMapping(value="/Quantity/{accessoriesQuantity}")
    public List<accessories> getAccessoriesByQuantity(@PathVariable Integer accessoriesQuantity) {
        return service.getAccessoriesByQuantity(accessoriesQuantity);
    }

    //GET http://localhost:8080/accessories/Rate/{user's input - Rating Number 1-5)
    // SHOULD return all products rated at the given number, however database keeps returning empty in
    //Postman. Reviewing.
    @GetMapping(value="/Rate/{accessoriesRating}")
    public List<accessories> getAccessoriesByRating(@PathVariable Integer accessoriesRating) {
        return service.getAccessoriesByRating(accessoriesRating);
    }

    //PUT http://localhost:8080/accessories/update/{user's input: accessoriesId}
    //Path currently receives a 400 error: Required request body is missing: public void
    //Reviewing Update method
    @PutMapping(value="/update/{accessoriesId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateAccessories(@RequestBody @Valid accessories access, @PathVariable Integer accessoriesId) {
        service.updateAccessories(access, accessoriesId);
    }


    //DELETE http://localhost:8080/accessories/delete/1
    // Path currently receives a 404 error: No message available
    @DeleteMapping(value="/delete/{accessoriesId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteAccessories(@PathVariable Integer accessoriesId) {
        service.deleteAccessories(accessoriesId);
    }
}
