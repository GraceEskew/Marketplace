package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface homeRepository extends JpaRepository<home, Integer> {
    List<home> findByHomeName(String homeName);
    List<home> findByHomePrice(Double homePrice);
    List<home> findByHomeQuantity(Integer homeQuantity);
    List<home> findByHomeRating(Integer homeRating);
}
