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

    @GetMapping(value="/{apparelID}")
    public apparel getApparelById(@PathVariable Integer apparelId) {
        return apparelService.getApparelById(apparelId);
    }

    @GetMapping(value="/{apparelName}")
    public List<apparel> getApparelByApparelName(@PathVariable String apparelName) {
        return apparelService.getApparelByName(apparelName);
    }

    @GetMapping(value="/{apparelQuantity}")
    public List<apparel> getApparelByApparelQuantity(@PathVariable Integer apparelQuantity) {
        return apparelService.getApparelByQuantity(apparelQuantity);
    }

    @GetMapping(value="/{apparelRating}")
    public List<apparel> getApparelByApparelRating(@PathVariable Integer apparelRating) {
        return apparelService.getApparelByRating(apparelRating);
    }

    @PutMapping(value="/{apparelId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateApparel(@RequestBody @Valid apparel app, @PathVariable Integer apparelId) {
        apparelService.updateApparel(app, apparelId);
    }

    @DeleteMapping(value="/{apparelId}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteApparel(@RequestBody @Valid apparel app, @PathVariable Integer apparelId) {
        apparelService.deleteApparel(apparelId);
    }




}
