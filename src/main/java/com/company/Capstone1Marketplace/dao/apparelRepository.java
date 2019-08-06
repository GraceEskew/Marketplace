package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.apparel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface apparelRepository extends JpaRepository<apparel, Integer> {
    List<apparel> findByApparelName(String apparelName);
    List<apparel> findByApparelPrice(Double apparelPrice);
    List<apparel> findByApparelRating(Integer apparelRating);
    List<apparel> findByApparelQuantity(Integer apparelQuantity);
}
