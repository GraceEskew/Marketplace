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
    List<accessories> findByAccessoriesQuantity(Integer accessoriesQuantity);
    //List<accessories> findByManufacturerName(manufacturer manu);
   // List<accessories> getAccessoriesRatedAbove4(Integer accessoriesRating);

}

/*NOTES___________________
* 1. Manufacturer List is commented out to prevent errors as its pending implementation
* 2. AccessoriesRated is commented out due to missing property error; When active it creates an unsatisfied
*       dependency for the java beans, which leaves the app unable to start.
* */
