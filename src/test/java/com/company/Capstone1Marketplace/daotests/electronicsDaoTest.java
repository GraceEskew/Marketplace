package com.company.Capstone1Marketplace.daotests;

import com.company.Capstone1Marketplace.dao.electronicsRepository;
import com.company.Capstone1Marketplace.dto.electronics;
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
public class electronicsDaoTest {

    @Autowired
    electronicsRepository electronicsRepo;

    electronics elec1;
    electronics elec2;
    electronics elec3;

    @Before
    public void setup() {
        elec1 = new electronics();
        elec1.setElectronicsName("TV");
        elec1.setElectronicsPrice(399.99);
        elec1.setElectronicsQuantity(5);
        elec1.setElectronicsRating(5);

        elec2 = new electronics();
        elec2.setElectronicsName("Stereo");
        elec2.setElectronicsPrice(99.99);
        elec2.setElectronicsQuantity(10);
        elec2.setElectronicsRating(4);

        elec3 = new electronics();
        elec3.setElectronicsName("Phone");
        elec3.setElectronicsPrice(499.99);
        elec3.setElectronicsQuantity(20);
        elec3.setElectronicsRating(5);
    }

    @Test
    @Transactional
    public void shouldAddElectronics() {
        electronicsRepo.save(elec3);
        assertNotNull(elec3.getElectronicsId());
    }

    @Test
    @Transactional
    public void shouldDeleteElectronics() {
        electronicsRepo.save(elec1);
        electronicsRepo.save(elec2);

        electronicsRepo.deleteById(elec2.getElectronicsId());

        Optional<electronics> fromRepo = electronicsRepo.findById(elec2.getElectronicsId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetElectronicsByName() {
        electronicsRepo.save(elec1);


        List<electronics> electronicsNameList = electronicsRepo.findByElectronicsName(elec1.getElectronicsName());
        assertEquals(elec1, electronicsNameList.get(0));
    }

    @Test
    @Transactional
    public void shouldGetElectronicsByRating() {
        electronicsRepo.save(elec2);

        List<electronics> electronicsRatingList = electronicsRepo.findByElectronicsRating(elec2.getElectronicsRating());
        assertEquals(elec2, electronicsRatingList.get(0));
    }

    @Test
    @Transactional
    public void shouldGetElectronicsByPrice() {
        electronicsRepo.save(elec3);
        electronicsRepo.save(elec2);

        List<electronics> electronicsPriceList = electronicsRepo.findByElectronicsPrice((elec3.getElectronicsPrice()));
        assertEquals(elec3, electronicsPriceList.get(0));
    }


}
