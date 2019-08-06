package com.company.Capstone1Marketplace.daotests;

import com.company.Capstone1Marketplace.dao.homeRepository;
import com.company.Capstone1Marketplace.dto.home;
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

//What's the difference btwn junit.framework.testcase & org.junit.Assert.

@RunWith(SpringRunner.class)
@SpringBootTest
public class homeDaoTest {
    @Autowired
    homeRepository homeRepo;

    home home1;
    home home2;
    home home3;

    @Before
    public void setUp() {
        home1 = new home();
        home1.setHomeName("Chair");
        home1.setHomePrice(49.99);
        home1.setHomeQuantity(15);
        home1.setHomeRating(2);

        home2 = new home();
        home2.setHomeName("Desk");
        home2.setHomePrice(39.99);
        home2.setHomeQuantity(7);
        home2.setHomeRating(5);

        home3 = new home();
        home3.setHomeName("Rug");
        home3.setHomePrice(19.99);
        home3.setHomeQuantity(25);
        home3.setHomeRating(4);
    }

    @Test
    @Transactional
    public void shouldAddHome() {
        homeRepo.save(home1);
        assertNotNull(home1.getHomeId());
    }

    @Test
    @Transactional
    public void shouldDeleteHome() {
        homeRepo.save(home1);
        homeRepo.save(home2);

        homeRepo.deleteById(home2.getHomeId());
        Optional<home> fromRepo = homeRepo.findById(home2.getHomeId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetHomeByName() {
        homeRepo.save(home3);

        List<home> homeNameList = homeRepo.findByHomeName(home3.getHomeName());
        assertEquals(home3, homeNameList.get(0));
    }

    @Test
    @Transactional
    public void shouldGetHomeByRating() {
        homeRepo.save(home2);

        List<home> homeRatingList = homeRepo.findByHomeRating(home2.getHomeRating());
        assertEquals(home2, homeRatingList.get(0));
    }
}
