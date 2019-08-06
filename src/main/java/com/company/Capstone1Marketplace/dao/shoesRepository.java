package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface shoesRepository extends JpaRepository<shoes, Integer> {
    List<shoes> findByShoesName(String shoesName);
    List<shoes> findByShoesPrice(Double shoesPrice);
    List<shoes> findByShoesQuantity(Integer shoesQuantity);
    List<shoes> findByShoesRating(Integer shoesRating);
}
