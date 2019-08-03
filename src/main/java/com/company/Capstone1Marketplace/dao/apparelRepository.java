package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.apparel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface apparelRepository extends JpaRepository<apparel, Integer> {
    List<apparel> findAllApparel();
    List<apparel> findByApparelName(String apparelName);
    List<apparel> findByApparelPrice(Double apparelPrice);
    List<apparel> findByApparelRating(Integer apparelRating);
    List<apparel> findByApparelQuantity(Integer apparelQuantity);
}
