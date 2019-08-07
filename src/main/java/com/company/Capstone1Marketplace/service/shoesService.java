package com.company.Capstone1Marketplace.service;


import com.company.Capstone1Marketplace.dao.shoesRepository;
import com.company.Capstone1Marketplace.dto.shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class shoesService {

    @Autowired
    private shoesRepository shoesRepo;


    //ADD SHOES
    public shoes addShoes(shoes shoe){ return shoesRepo.save(shoe);}

    //UPDATE SHOES
    public void updateShoes(shoes shoe, Integer shoesId){
        if (shoe.getShoesId() != shoesId) {
            throw new IllegalArgumentException("Shoes ID must match ID provided");
        }
        shoesRepo.save(shoe);
    }

    //DELETE SHOES
    public void deleteShoes(Integer shoesId){
        shoesRepo.deleteById(shoesId);
    }

    //GET ALL SHOES
    public List<shoes> getAllShoes() {return shoesRepo.findAll();}


    //SHOES BY ID
    public shoes getShoesById(Integer shoesId) {
        return shoesRepo.getOne(shoesId);
    }

    //SHOES BY NAME
    public List<shoes> getShoesByName(String shoesName){
        return shoesRepo.findByShoesName(shoesName);
    }

    //SHOES BY PRICE
    public List<shoes> getShoesByPrice(Double shoesPrice){
        return shoesRepo.findByShoesPrice(shoesPrice);
    }

    //SHOES BY QUANTITY
    public List<shoes> getShoesByQuantity(Integer shoesQuantity){
        return shoesRepo.findByShoesQuantity(shoesQuantity);
    }

    // SHOES BY RATING
    public List<shoes> getShoesByRating(Integer shoesRating) {
        return shoesRepo.findByShoesRating(shoesRating);
    }

    //SHOES PRODUCTS RATED ABOVE 4
    public List<shoes> getShoesRatedAbove4(Integer shoesRating) {
        List<shoes> shoesList = shoesRepo.findByShoesRating(shoesRating)
                .stream()
                .filter(apparel -> apparel.getShoesRating() > 4)
                .collect(Collectors.toList());
        return shoesList;
    }

//    public List<shoes> getShoesRatedAbove4(Double shoesPrice) {
//        List<shoes> shoesList = shoesRepo.findByShoesPrice(shoesPrice)
//                .sort(shoe) LOOK UP COLLECTIONS.SORT(LIST, COLLECTIONS.REVERSEORDER)
//    }
}
