package com.company.Capstone1Marketplace.service;


import com.company.Capstone1Marketplace.dao.beautyRepository;
import com.company.Capstone1Marketplace.dto.beauty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class beautyService {

    @Autowired
    private beautyRepository beautyRepo;

    public beauty addBeauty(beauty beauty) {
        return beautyRepo.save(beauty);}

   // public List<beauty> getAllBeauty() {return beautyRepo.findAll();}

    public beauty getBeautyById(Integer beautyId) {return beautyRepo.getOne(beautyId);}

    public List<beauty> getBeautyByName(String beautyName) {return beautyRepo.findByBeautyName(beautyName);}

    public List<beauty> getBeautyByQuantity(Integer beautyQuantity) {return beautyRepo.findByBeautyQuantity(beautyQuantity);}

    public List<beauty> getBeautyByRating(Integer beautyRating) {return beautyRepo.findByBeautyRating(beautyRating);}

    // BEAUTY PRODUCTS RATED ABOVE 4
    public List<beauty> getBeautyRatedAbove4(Integer beautyRating) {
        List<beauty> appList = beautyRepo.findByBeautyRating(beautyRating)
                .stream()
                .filter(apparel -> apparel.getBeautyRating() > 4)
                .collect(Collectors.toList());
        return appList;
    }

    public void updateBeauty(beauty beau, Integer beautyId) {
        if (beau.getBeautyId() != beautyId) {
            throw new IllegalArgumentException("Beauty Id must match Id provided.");
        }
        beautyRepo.save(beau);
    }

    public void deleteBeauty(Integer beautyId) {
        beautyRepo.deleteById(beautyId);
    }
}
