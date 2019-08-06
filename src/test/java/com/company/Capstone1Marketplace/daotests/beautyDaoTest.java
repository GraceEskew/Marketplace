package com.company.Capstone1Marketplace.daotests;


import com.company.Capstone1Marketplace.dao.beautyRepository;
import com.company.Capstone1Marketplace.dto.beauty;
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

public class beautyDaoTest {
    @Autowired
    beautyRepository beautyRepo;

    beauty beauty1;
    beauty beauty2;
    beauty beauty3;

    @Before
    public void setUp() {
        beauty1 = new beauty();
        beauty1.setBeautyName("Lipstick");
        beauty1.setBeautyPrice(9.99);
        beauty1.setBeautyQuantity(10);
        beauty1.setBeautyRating(2);

        beauty2 = new beauty();
        beauty2.setBeautyName("Setting Powder");
        beauty2.setBeautyPrice(5.99);
        beauty2.setBeautyQuantity(5);
        beauty2.setBeautyRating(5);

        beauty3 = new beauty();
        beauty3.setBeautyName("Perfume");
        beauty3.setBeautyPrice(24.99);
        beauty3.setBeautyQuantity(5);
        beauty3.setBeautyRating(2);
    }

    @Test
    @Transactional
    public void shouldAddBeauty() {
        beautyRepo.save(beauty1);

        assertNotNull(beauty1.getBeautyId());
    }

    @Test
    @Transactional
    public void shouldDeleteBeauty() {
        beautyRepo.save(beauty1);
        beautyRepo.save(beauty2);
        beautyRepo.save(beauty3);

        beautyRepo.deleteById(beauty1.getBeautyId());

        Optional<beauty> fromRepo = beautyRepo.findById(beauty1.getBeautyId());

        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetBeautyByName() {
        beautyRepo.save(beauty2);
        beautyRepo.save(beauty1);

        List<beauty> beautyNameList = beautyRepo.findByBeautyName(beauty2.getBeautyName());

        assertEquals(beauty2, beautyNameList.get(0));
    }




}
