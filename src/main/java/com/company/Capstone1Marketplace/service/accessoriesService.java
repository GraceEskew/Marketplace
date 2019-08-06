package com.company.Capstone1Marketplace.service;

import com.company.Capstone1Marketplace.dao.accessoriesRepository;
import com.company.Capstone1Marketplace.dto.accessories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class accessoriesService {

    @Autowired
    accessoriesRepository accessoriesRepo;

    public accessories addAccessories(accessories access) {
        return accessoriesRepo.save(access);
    }

    public List<accessories> getAllAccessories() {
        return accessoriesRepo.findAll();
    }

    public accessories getAccessoriesById(Integer accessoriesId) {
        return accessoriesRepo.getOne(accessoriesId);
    }

    public List<accessories> getAccessoriesByRating(Integer accessoriesRating) {
        return accessoriesRepo.findByAccessoriesQuantity(accessoriesRating);
    }
    public List<accessories> getAccessoriesByName(String accessoriesName) {
        return accessoriesRepo.findByAccessoriesName(accessoriesName);
    }

    public List<accessories> getAccessoriesByQuantity(Integer accessoriesQuantity) {
        return accessoriesRepo.findByAccessoriesQuantity(accessoriesQuantity);
    }

    public List<accessories> getAccessoriesByPrice(Double accessoriesPrice) {
        return accessoriesRepo.findByAccessoriesPrice(accessoriesPrice);
    }

    public void updateAccessories(accessories access, Integer accessoriesId) {
        if (access.getAccessoriesId() != accessoriesId) {
            throw new IllegalArgumentException("Accessory ID must match ID provided");
        }
        accessoriesRepo.save(access);
    }

    // ACCESSORIES RATED ABOVE 4
    public List<accessories> getAccessoriesRatedAbove4(Integer accessoriesRating) {
        List<accessories> accessList = accessoriesRepo.findByAccessoriesRating(accessoriesRating)
                .stream()
                .filter(accessories -> accessories.getAccessoriesRating() > 4)
                .collect(Collectors.toList());
        return accessList;
    }

    public void deleteAccessories(Integer accessoriesId) {
        accessoriesRepo.deleteById(accessoriesId);
    }
}

/* NOTES ___________________
*
*
*
*
* */
