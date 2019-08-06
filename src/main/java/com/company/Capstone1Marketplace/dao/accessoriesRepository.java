package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.accessories;
import com.company.Capstone1Marketplace.dto.manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface accessoriesRepository extends JpaRepository<accessories, Integer> {
    List<accessories> findByAccessoriesName(String accessoriesName);
    List<accessories> findByAccessoriesPrice(Double accessoriesPrice);
    List<accessories> findByAccessoriesRating(Integer accessoriesRating);
    //List<accessories> findByManufacturerName(manufacturer manu);
    List<accessories> findByAccessoriesQuantity(Integer accessoriesQuantity);
    List<accessories> getAccessoriesRatedAbove4(Integer accessoriesRating);


}
