package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface gardenRepository extends JpaRepository<garden, Integer> {
    List<garden> findByGardenName(String gardenName);
    List<garden> findByGardenPrice(Double gardenPrice);
    List<garden> findByGardenQuantity(Integer gardenQuantity);
    List<garden> findByGardenRating(Integer gardenRating);
}
