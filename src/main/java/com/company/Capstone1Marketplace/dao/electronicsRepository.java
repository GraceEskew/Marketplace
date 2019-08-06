package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.electronics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface electronicsRepository extends JpaRepository<electronics, Integer> {
    List<electronics> findByElectronicsName(String electronicsName);
    List<electronics> findByElectronicsPrice (Double electronicsPrice);
    List<electronics> findByElectronicsQuantity (Integer electronicsQuantity);
    List<electronics> findByElectronicsRating (Integer electronicsRating);
}
