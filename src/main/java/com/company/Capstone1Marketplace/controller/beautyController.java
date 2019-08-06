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


    // STATIC ISSUE WITH ADDBEAUTY - CITING DTO.
//    @PostMapping
//    @ResponseStatus(value= HttpStatus.CREATED)
//    public beauty addBeauty(@RequestBody @Valid beauty beau) {
//        return beautyService.addBeauty(beau);
//    }

    @GetMapping(value="/{beautyId}")
    public beauty getBeautyById(@PathVariable Integer beautyId) {return beauService.getBeautyById(beautyId);}

    @GetMapping(value="/{beautyName}")
    public List<beauty> getBeautyByName(@PathVariable String beautyName) {return beauService.getBeautyByName(beautyName);}

    @GetMapping(value="/{beautyQuantity}")
    public List<beauty> getBeautyByQuantity(@PathVariable Integer beautyQuantity) {return beauService.getBeautyByQuantity(beautyQuantity);}

    @GetMapping(value="/{beautyRating}")
    public List<beauty> getBeautyByRating(@PathVariable Integer beautyRating) {return beauService.getBeautyByRating(beautyRating);}

    @PutMapping(value="/{beautyId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateBeauty(@RequestBody @Valid beauty beau, @PathVariable Integer beautyId) {
        beauService.updateBeauty(beau, beautyId);
    }

    @DeleteMapping(value="/{beautyId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteBeauty(@RequestBody @Valid beauty beau, @PathVariable Integer beautyId) {
        beauService.deleteBeauty(beautyId);
    }



}
