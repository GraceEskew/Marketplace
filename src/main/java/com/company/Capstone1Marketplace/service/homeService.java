package com.company.Capstone1Marketplace.service;


import com.company.Capstone1Marketplace.dao.homeRepository;
import com.company.Capstone1Marketplace.dto.home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class homeService {

    @Autowired
    private homeRepository homeRepo;

    public home addHome(home home) {
        return homeRepo.save(home);
    }

    public home getHomeById(Integer homeId) {
        return homeRepo.getOne(homeId);
    }

    public List<home> getHomeByName(String homeName) {
        return homeRepo.findByHomeName(homeName);
    }

    public List<home> getHomeByPrice(Double homePrice) {
        return homeRepo.findByHomePrice(homePrice);
    }

    public List<home> getHomeByQuantity(Integer homeQuantity) {
        return homeRepo.findByHomeQuantity(homeQuantity);
    }

    public List<home> getHomeByRating(Integer homeRating) {
        return homeRepo.findByHomeRating(homeRating);
    }


    //HOME PRODUCTS RATED ABOVE 4
    public List<home> getHomesRatedAbove4(Integer homeRating) {
        List<home> homeList = homeRepo.findByHomeRating(homeRating)
                .stream()
                .filter(apparel -> apparel.getHomeRating() > 4)
                .collect(Collectors.toList());
        return homeList;
    }

    public void updateHome(home home, Integer homeId) {
        if (home.getHomeId() != homeId) {
            throw new IllegalArgumentException("Home ID must match ID provided.");
        }
        homeRepo.save(home);
    }

    public void deleteHome(Integer homeId) {
        homeRepo.deleteById(homeId);
    }


}
