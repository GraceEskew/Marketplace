package com.company.Capstone1Marketplace.service;


import com.company.Capstone1Marketplace.dao.electronicsRepository;
import com.company.Capstone1Marketplace.dto.electronics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class electronicsService {

    @Autowired
    private electronicsRepository elecRepo;

    public electronics addElectronics(electronics electronics){
        return elecRepo.save(electronics);
    }

    public List<electronics> getAllElectronics() { return elecRepo.findAll();}

    public electronics getElectronicsById(Integer electronicsId) {
        return elecRepo.getOne(electronicsId);
    }

    public List<electronics> getElectronicsByName(String electronicsName) {
        return elecRepo.findByElectronicsName(electronicsName);
    }

    public List<electronics> getElectronicsByPrice(Double electronicsPrice) {
        return elecRepo.findByElectronicsPrice(electronicsPrice);
    }

    public List<electronics> getElectronicsByQuantity(Integer electronicsQuantity) {
        return elecRepo.findByElectronicsQuantity(electronicsQuantity);
    }

    public List<electronics> getElectronicsByRating(Integer electronicsRating) {
        return elecRepo.findByElectronicsRating(electronicsRating);
    }

    // ELECTRONICS PRODUCTS RATED ABOVE 4
    public List<electronics> getElectronicsRatedAbove4(Integer electronicsRating) {
        List<electronics> appList = elecRepo.findByElectronicsRating(electronicsRating)
                .stream()
                .filter(apparel -> apparel.getElectronicsRating() > 4)
                .collect(Collectors.toList());
        return appList;

    }
    public void updateElectronics(electronics elec, Integer electronicsId) {
        if (elec.getElectronicsId() != electronicsId) {
            throw new IllegalArgumentException("Electronics Id must match Id provided");
        }
        elecRepo.save(elec);
    }

    public void deleteElectronics(Integer electronicsId) {
        elecRepo.deleteById(electronicsId);
    }
}
