package com.company.Capstone1Marketplace.daotests;


import com.company.Capstone1Marketplace.dao.gardenRepository;
import com.company.Capstone1Marketplace.dto.garden;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class gardenDaoTest {

    @Autowired
    gardenRepository gardenRepo;

    garden garden1;
    garden garden2;
    garden garden3;

    @Before
    public void setUp() {
        garden1 = new garden();
        garden1.setGardenName("Seeds");
        garden1.setGardenPrice(1.99);
        garden1.setGardenQuantity(50);
        garden1.setGardenRating(3);

        garden2 = new garden();
        garden2.setGardenName("Gloves");
        garden2.setGardenPrice(14.99);
        garden2.setGardenQuantity(5);
        garden2.setGardenRating(1);

        garden3 = new garden();
        garden3.setGardenName("Assorted Tool Pack");
        garden3.setGardenPrice(29.99);
        garden3.setGardenQuantity(3);
        garden3.setGardenRating(5);
    }

    @Test
    @Transactional
    public void shouldAddGarden() {
        gardenRepo.save(garden1);
        assertNotNull(garden1.getGardenId());
    }

    @Test
    @Transactional
    public void shouldDeleteGarden() {
        gardenRepo.save(garden1);
        gardenRepo.save(garden2);

        gardenRepo.deleteById(garden2.getGardenId());

        Optional<garden> fromRepo = gardenRepo.findById(garden2.getGardenId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetGardenByName() {
        gardenRepo.save(garden1);

        List<garden> gardenNameList = gardenRepo.findByGardenName(garden1.getGardenName());
        assertEquals(garden1, gardenNameList.get(0));
    }

    //getting an Index:1 size:1 error when I try to run anything past 0
    //tried adding in as an arrayList, with no new results
    @Test
    @Transactional
    public void shouldGetGardenByRating() {
        gardenRepo.save(garden1);
        gardenRepo.save(garden2);

        List<garden> gardenRatingList = gardenRepo.findByGardenRating(garden1.getGardenRating());
        assertEquals(garden1, gardenRatingList.get(0));
    }

}
