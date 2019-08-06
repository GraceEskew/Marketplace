package com.company.Capstone1Marketplace.service;


import com.company.Capstone1Marketplace.dao.gardenRepository;
import com.company.Capstone1Marketplace.dto.garden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class gardensService {

    @Autowired
    private gardenRepository gardenRepo;

    public garden addGarden(garden gar){
        return gardenRepo.save(gar);
    }

    public garden getGardenById(Integer gardenId){
        return gardenRepo.getOne(gardenId);
    }

    public List<garden> getGardenByName(String gardenName) {
        return gardenRepo.findByGardenName(gardenName);
    }

    public List<garden> findGardenByPrice(Double gardenPrice) {
        return gardenRepo.findByGardenPrice(gardenPrice);
    }

    public List<garden> findGardenByQuantity(Integer gardenQuantity) {
        return gardenRepo.findByGardenQuantity(gardenQuantity);
    }

    public List<garden> findGardenByRating(Integer gardenRating) {

        return gardenRepo.findByGardenRating(gardenRating);
    }

    //GARDEN PRODUCTS RATED ABOVE 4
    public List<garden> getGardensRatedAbove4(Integer gardenRating) {
        List<garden> gardenList = gardenRepo.findByGardenRating(gardenRating)
                .stream()
                .filter(apparel -> apparel.getGardenRating() > 4)
                .collect(Collectors.toList());
        return gardenList;
    }

    public void updateGarden (garden gar, Integer gardenId) {
        if (gar.getGardenId() != gardenId) {
            throw new IllegalArgumentException("Garden Id must match ID provided.");
        }
        gardenRepo.save(gar);
    }

    public void deleteGarden (Integer gardenId) {
        gardenRepo.deleteById(gardenId);
    }
}
