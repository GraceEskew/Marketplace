package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.beauty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface beautyRepository extends JpaRepository<beauty, Integer> {
    List<beauty> findByBeautyName(String beautyName);
    List<beauty> findByBeautyPrice(Double beautyPrice);
    List<beauty> findByBeautyRating(Integer beautyRating);
    List<beauty> findByBeautyQuantity(Integer beautyQuantity);
}
