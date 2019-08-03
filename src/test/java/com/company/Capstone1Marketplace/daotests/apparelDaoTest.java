package com.company.Capstone1Marketplace.daotests;

import com.company.Capstone1Marketplace.dao.apparelRepository;
import com.company.Capstone1Marketplace.dao.manufacturerRepository;
import com.company.Capstone1Marketplace.dto.apparel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest

public class apparelDaoTest {

    @Autowired
    apparelRepository apparelRepo;
//    @Autowired
//    manufacturerRepository manuRepo;

    apparel app1;
    apparel app2;
    apparel app3;
    apparel app4;
    apparel app5;

//    manufacturer manu4;
//    manufacturer manu5;
//    manufacturer manu6;

    @Before
    public void setUp() {
       //apparelRepo.deleteAll();
       // manuRepo.deleteAll();

        app1 = new apparel();
        app1.setApparelName("TShirts");
        app1.setApparelPrice(14.99);
        app1.setApparelQuantity(15);
        app1.setApparelRating(1);

        app2 = new apparel();
        app2.setApparelName("Scarf");
        app2.setApparelPrice(10.99);
        app2.setApparelQuantity(25);
        app2.setApparelRating(2);

        app3 = new apparel();
        app3.setApparelName("Jeans");
        app3.setApparelPrice(24.99);
        app3.setApparelQuantity(17);
        app3.setApparelRating(3);

        app4 = new apparel();
        app4.setApparelName("Dress");
        app4.setApparelPrice(34.99);
        app4.setApparelQuantity(2);
        app4.setApparelRating(4);

        app5 = new apparel();
        app5.setApparelName("Suit");
        app5.setApparelPrice(199.99);
        app5.setApparelQuantity(1);
        app5.setApparelRating(5);

//        manu4.setManufacturerName("Tammy's Trends");
//        manu4.setManufacturerStreet("11 South Street");
//        manu4.setManufacturerCity("Ciper");
//        manu4.setManufacturerState("ND");
//        manu4.setManufacturerZipCode("3110");
//        manu4.setManufacturerPhone("121-121-1211");
//        manu4.setManufacturerContact("Tammy");
//
//        manu5 = new manufacturer();
//        manu5.setManufacturerName("Hipster Hocks");
//        manu5.setManufacturerStreet("1152 B Street");
//        manu5.setManufacturerCity("Big Town");
//        manu5.setManufacturerState("LA");
//        manu5.setManufacturerZipCode("1155");
//        manu5.setManufacturerPhone("212-212-2121");
//        manu5.setManufacturerContact("Alfonzo");
//
//        manu6 = new manufacturer();
//        manu6.setManufacturerName("Deets n' Details");
//        manu6.setManufacturerStreet("3501 Lakeshore Ave #2");
//        manu6.setManufacturerCity("Riverton");
//        manu6.setManufacturerState("WI");
//        manu6.setManufacturerZipCode("3002");
//        manu6.setManufacturerPhone("343-343-3433");
//        manu6.setManufacturerContact("Peter");
    }

    @Test
    @Transactional
        public void shouldFindAllApparel() {
        apparelRepo.save(app1);
        apparelRepo.save(app2);

        List<apparel> apparelList = new ArrayList<>();
        apparelList.add(app1);
        apparelList.add(app2);

        List<apparel> fromRepo = apparelRepo.findAllApparel();

        assertEquals(apparelList, fromRepo);
    }

    @Test
    @Transactional
    public void shouldAddApparel() {
        apparelRepo.save(app1);

        assertNotNull(app1.getApparelId());
    }

    @Test
    @Transactional
    public void shouldDeleteApparel() {
        apparelRepo.save(app1);
        apparelRepo.save(app2);
        apparelRepo.save(app3);
        apparelRepo.save(app4);
        apparelRepo.save(app5);

        apparelRepo.deleteById(app1.getApparelId());

        Optional<apparel> fromRepo = apparelRepo.findByApparelId(app1.getApparelId());

        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetByName() {
        apparelRepo.save(app1);
        apparelRepo.save(app2);
        apparelRepo.save(app3);
        apparelRepo.save(app4);
        apparelRepo.save(app5);

        List<apparel> apparelNameList = apparelRepo.findByApparelName(app3.getApparelName());

        assertEquals("Dress", apparelNameList.get(2));

    }

    @Test
    @Transactional
    public void shouldGetByPrice() {
        apparelRepo.save(app1);
        apparelRepo.save(app2);
        apparelRepo.save(app3);
        apparelRepo.save(app4);
        apparelRepo.save(app5);

        List<apparel> apparelPriceList = apparelRepo.findByApparelPrice(app2.getApparelPrice());

        assertEquals(10.99, apparelPriceList.get(1));

    }

    @Test
    @Transactional
    public void shouldGetByRating() {
        apparelRepo.save(app1);
        apparelRepo.save(app2);
        apparelRepo.save(app3);
        apparelRepo.save(app4);
        apparelRepo.save(app5);

        List<apparel> apparelRatingList = apparelRepo.findByApparelRating(app1.getApparelRating());

        assertEquals(1, apparelRatingList.get(0));
    }

    @Test
    @Transactional
    public void shouldGetByQuantity() {
        apparelRepo.save(app1);
        apparelRepo.save(app2);
        apparelRepo.save(app3);
        apparelRepo.save(app4);
        apparelRepo.save(app5);

        List<apparel> apparelQuantityList = apparelRepo.findByApparelQuantity(app5.getApparelQuantity());

        assertEquals(1, apparelQuantityList.get(4));
    }

//    @After
//    public void tearDown() {
//       apparelRepo.deleteAll();
//    }

}


//note
//PROBLEM: HOW CAN I CALL MANUFACTURER INFO IN? METHOD OVERLOADING WON'T WORK BECAUSE
//ITS THE SAME DATA TYPE, SAME NUMBER OF PARAMETER

//        manuRepo.save(manu4);
//        app1.setManu(manu4);
//        apparelRepo.save(app1);
//
//        app2.setManu(manu4);
//        apparelRepo.save(app2);
//
//        manuRepo.save(manu5);
//        app3.setManu(manu5);
//        apparelRepo.save(app3);
//
//        app4.setManu(manu5);
//        apparelRepo.save(app4);
//
//        manuRepo.save(manu6);
//        app5.setManu(manu6);
//        apparelRepo.save(app5);

