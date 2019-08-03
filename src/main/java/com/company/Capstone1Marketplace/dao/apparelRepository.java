package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.apparel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface apparelRepository extends JpaRepository<apparel, Integer> {
    List<apparel> getAllApparel();
    List<apparel> findByName(String apparelName);
    List<apparel> findByPrice(Double apparelPrice);
    List<apparel> findByRating(Integer apparelRating);
    List<apparel> findByQuantity(Integer apparelQuantity);
}
