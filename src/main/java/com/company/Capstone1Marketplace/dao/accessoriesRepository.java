package com.company.Capstone1Marketplace.dao;

import com.company.Capstone1Marketplace.dto.accessories;
import com.company.Capstone1Marketplace.dto.manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface accessoriesRepository extends JpaRepository<accessories, Integer> {
    List<accessories> getAllAccessories();
    List<accessories> findByName(String accessoriesName);
    List<accessories> findByPrice(Double accessoriesPrice);
    List<accessories> findByRating(Integer accessoriesRating);
    //List<accessories> findByManufacturerName(manufacturer manu);
    List<accessories> findByQuantity(Integer accessoriesQuantity);

}
