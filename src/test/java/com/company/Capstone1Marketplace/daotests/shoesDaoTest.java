package com.company.Capstone1Marketplace.daotests;

import com.company.Capstone1Marketplace.dao.shoesRepository;
import com.company.Capstone1Marketplace.dto.shoes;
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
public class shoesDaoTest {
    @Autowired
    shoesRepository shoesRepo;

    shoes shoe1;
    shoes shoe2;
    shoes shoe3;

    @Before
    public void setUp() {
        shoe1 = new shoes();
        shoe1.setShoesName("Sneakers");
        shoe1.setShoesPrice(14.99);
        shoe1.setShoesQuantity(12);
        shoe1.setShoesRating(3);

        shoe2 = new shoes();
        shoe2.setShoesName("Stilettos");
        shoe2.setShoesPrice(19.99);
        shoe2.setShoesQuantity(10);
        shoe2.setShoesRating(2);

        shoe3 = new shoes();
        shoe3.setShoesName("Hightops");
        shoe3.setShoesPrice(74.99);
        shoe3.setShoesQuantity(3);
        shoe3.setShoesRating(5);
    }

    @Test
    @Transactional
    public void shouldAddShoes() {
        shoesRepo.save(shoe1);
        assertNotNull(shoe1.getShoesId());
    }

    @Test
    @Transactional
    public void shouldDeleteShoes() {
        shoesRepo.save(shoe2);
        shoesRepo.save(shoe1);

        shoesRepo.deleteById(shoe2.getShoesId());
        Optional<shoes> fromRepo = shoesRepo.findById(shoe2.getShoesId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetShoesByName() {
        shoesRepo.save(shoe1);

        List<shoes> shoesNameList = shoesRepo.findByShoesName(shoe1.getShoesName());
        assertEquals(shoe1, shoesNameList.get(0));
    }

    @Test
    @Transactional
    public void shouldGetShoesByRating() {
        shoesRepo.save(shoe3);

        List<shoes> shoesRatingList = shoesRepo.findByShoesRating(shoe3.getShoesRating());
        assertEquals(shoe3, shoesRatingList.get(0));
    }
}
