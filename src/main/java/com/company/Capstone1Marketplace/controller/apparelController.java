package com.company.Capstone1Marketplace.controller;


import com.company.Capstone1Marketplace.dto.apparel;
import com.company.Capstone1Marketplace.service.apparelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/apparel")
public class apparelController {

    @Autowired
    private apparelService apparelService;

    @PostMapping
    @ResponseStatus(value= HttpStatus.CREATED)
    public apparel addApparel(@RequestBody @Valid apparel app) {
        return apparelService.addApparel(app);
    }

    //GET  http://localhost:8080/accessories -- gets entire list of accessories
    @GetMapping
    public List<apparel> getAllAccessories() {
        return apparelService.getAllAccessories();
    }


    //GET http://localhost:8080/apparel/id/{user's input: product ID}
    // returns product information via ID number
    @GetMapping(value="/id/{apparelID}")
    public apparel getApparelById(@PathVariable ("id") Integer apparelId) {
        return (apparel) apparelService.getApparelById(apparelId);
    }

    //GET http://localhost:8080/apparel/name/{user's input: product name}
    // returns product information via product name
    @GetMapping(value="/name/{apparelName}")
    public List<apparel> getApparelByApparelName(@PathVariable String apparelName) {
        return apparelService.getApparelByName(apparelName);
    }

    //GET http://localhost:8080/apparel/price/{user's input: product price}
    // returns a list of products with prices matching user's input
    @GetMapping(value="/price/{apparelPrice}")
    public  List<apparel> getApparelByPrice(@PathVariable Double apparelPrice) {
        return apparelService.getApparelByPrice(apparelPrice);
    }


    //GET http://localhost:8080/apparel/quantity/{user's input: product quantity}
    // returns list of products with the same quantity count
    @GetMapping(value="/quantity/{apparelQuantity}")
    public List<apparel> getApparelByApparelQuantity(@PathVariable Integer apparelQuantity) {
        return apparelService.getApparelByQuantity(apparelQuantity);
    }

    //GET http://localhost:8080/apparel/rate/{user's input: product rating}
    // returns list of products with the same quantity count
    @GetMapping(value="/rate/{apparelRating}")
    public List<apparel> getApparelByApparelRating(@PathVariable Integer apparelRating) {
        return apparelService.getApparelByRating(apparelRating);
    }


    //PUT http://localhost:8080/apparel/update/{user's input: apparelId}
    //Path currently receives a 400 error: Required request body is missing: public void
    //Reviewing
    @PutMapping(value="/update/{apparelId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateApparel(@RequestBody @Valid apparel app, @PathVariable Integer apparelId) {
        apparelService.updateApparel(app, apparelId);
    }

    //DELETE http://localhost:8080/apparel/delete/{user's input: apparelId
    // Path currently receives a 404 error: No message available
    @DeleteMapping(value="/delete/{apparelId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteApparel(@RequestBody @Valid apparel app, @PathVariable Integer apparelId) {
        apparelService.deleteApparel(apparelId);
    }
}

/*Notes__________________
* 1. based on google: the JsonMappingException: out of START_ARRAY token may be revolving around an invalid array of objects. Attempting to review
*       and correct as it is effecting multiple routes, but given the time constraints, I may have to wait until after the project is graded to really
*       dig into this and correct. Based on the fact that most of the routes effected involve the id, might be
*       a good place to start.
*
*
* */