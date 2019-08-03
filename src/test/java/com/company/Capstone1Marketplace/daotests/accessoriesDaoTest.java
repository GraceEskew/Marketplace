package com.company.Capstone1Marketplace.daotests;

import com.company.Capstone1Marketplace.dao.accessoriesRepository;
import com.company.Capstone1Marketplace.dao.manufacturerRepository;
import com.company.Capstone1Marketplace.dto.accessories;
import com.company.Capstone1Marketplace.dto.manufacturer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class accessoriesDaoTest {

    @Autowired
    accessoriesRepository accessRepo;
    @Autowired
    manufacturerRepository manuRepo;

    accessories access1;
    accessories access2;
    accessories access3;
    accessories access4;
    accessories access5;

    manufacturer manu1;
    manufacturer manu2;
    manufacturer manu3;

    @Before
    public void setUp() {
//        accessRepo.deleteAll();
//        manuRepo.deleteAll();

        access1 = new accessories();
        access1.setAccessoriesName("Necklace");
        access1.setAccessoriesPrice(3.99);
        access1.setAccessoriesQuantity(10);
        access1.setAccessoriesRating(3);

        access2 = new accessories();
        access2.setAccessoriesName("Bracelet");
        access2.setAccessoriesQuantity(20);
        access2.setAccessoriesPrice(1.99);
        access2.setAccessoriesRating(2);

        access3 = new accessories();
        access3.setAccessoriesName("earrings");
        access3.setAccessoriesPrice(7.99);
        access3.setAccessoriesQuantity(15);
        access3.setAccessoriesRating(4);

        access4 = new accessories();
        access4.setAccessoriesName("cuff links");
        access4.setAccessoriesPrice(49.99);
        access4.setAccessoriesQuantity(2);
        access4.setAccessoriesRating(5);

        access5 = new accessories();
        access5.setAccessoriesName("string");
        access5.setAccessoriesQuantity(150);
        access5.setAccessoriesPrice(99.99);
        access5.setAccessoriesRating(1);

//        manu1.setManufacturerName("Bob's Buckets");
//        manu1.setManufacturerStreet("10 Main Street");
//        manu1.setManufacturerCity("Cityville");
//        manu1.setManufacturerState("TX");
//        manu1.setManufacturerZipCode("1110");
//        manu1.setManufacturerPhone("111-111-1111");
//        manu1.setManufacturerContact("Bob");
//
//        manu2 = new manufacturer();
//        manu2.setManufacturerName("New Age Bobbles");
//        manu2.setManufacturerStreet("11 A Street");
//        manu2.setManufacturerCity("City Town");
//        manu2.setManufacturerState("AZ");
//        manu2.setManufacturerZipCode("1100");
//        manu2.setManufacturerPhone("222-222-2222");
//        manu2.setManufacturerContact("Alice");
//
//        manu3 = new manufacturer();
//        manu3.setManufacturerName("We Make Stuff");
//        manu3.setManufacturerStreet("7001 Oceans Ave #2");
//        manu3.setManufacturerCity("City Valley");
//        manu3.setManufacturerState("CA");
//        manu3.setManufacturerZipCode("5005");
//        manu3.setManufacturerPhone("333-333-3333");
//        manu3.setManufacturerContact("Guy");
    }

    @Test
    @Transactional
    public void shouldGetAccessories() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessoriesList = new ArrayList<>();
        accessoriesList.add(access1);
        accessoriesList.add(access2);
        accessoriesList.add(access3);
        accessoriesList.add(access4);
        accessoriesList.add(access5);

        List<accessories> fromRepo = accessRepo.findAllAccessories();

        assertEquals(accessoriesList, fromRepo);

    }

    @Test
    @Transactional
    public void shouldGetAccessoriesByQuantity() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessQuantityList = accessRepo.findByAccessoriesQuantity(access1.getAccessoriesQuantity());

        assertEquals(access1, accessQuantityList.get(0));
    }

    @Test
    @Transactional
    public void shouldAddAccessories(){
        manuRepo.save(manu1);
        accessRepo.save(access1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        accessRepo.save(access3);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        accessRepo.save(access5);

        assertNotNull(access1.getAccessoriesId());
        assertNotNull(access2.getAccessoriesId());
        assertNotNull(access3.getAccessoriesId());
        assertNotNull(access4.getAccessoriesId());
        assertNotNull(access5.getAccessoriesId());
    }

    @Test
    @Transactional
    public void shouldDeleteAccessories() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        accessRepo.deleteById(access1.getAccessoriesId());

        Optional<accessories> fromRepo = accessRepo.findById(access1.getAccessoriesId());

        assertFalse(fromRepo.isPresent());
    }

    //service
    /*
    @Test
    @Transactional
    public void shouldSortAccessoriesByPriceAscending() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessoriesList = new ArrayList<>();
        accessoriesList.add(access1);
        accessoriesList.add(access2);
        accessoriesList.add(access3);
        accessoriesList.add(access4);
        accessoriesList.add(access5);

        Collections.sort(accessoriesList);

    }*/

    //service?
   /* @Test
    @Transactional
    public void shouldSortAccessoriesByPriceDescending() {} */

    @Test
    @Transactional
    public void shouldGetAccessoriesByName() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessNameList = accessRepo.findByAccessoriesName(access3.getAccessoriesName());

        assertEquals("earrings", accessNameList.get(2));
    }

    @Test
    @Transactional
    public void shouldGetAccessoriesByPrice() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessPriceList = accessRepo.findByAccessoriesPrice(access2.getAccessoriesPrice());

        assertEquals(access2, accessPriceList.get(1));
    }

    @Test
    @Transactional
    public void shouldGetAccessoriesByRating() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessRatingList = accessRepo.findByAccessoriesRating(access3.getAccessoriesRating());

        assertEquals(access3, accessRatingList.get(2));
    }

    /* --- nd to ask about why access5.getManu() wouldn't work
    @Test
    @Transactional
    public void shouldGetAccessoriesByManufacturer() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> fromRepo = accessRepo.findByManufacturerName(access5.getManu().getManufacturerName());
        assertEquals(4, fromRepo.size());

        fromRepo = accessRepo.findByManufacturerName(access1.getManu().getManufacturerName());
        assertEquals(0, fromRepo.size());
    } */


    //service
    @Test
    @Transactional
    public void shouldGetAccessoriesRated5() {
        manuRepo.save(manu1);
        access1.setManu(manu1);
        accessRepo.save(access1);

        access2.setManu(manu1);
        accessRepo.save(access2);

        manuRepo.save(manu2);
        access3.setManu(manu2);
        accessRepo.save(access3);

        access4.setManu(manu2);
        accessRepo.save(access4);

        manuRepo.save(manu3);
        access5.setManu(manu3);
        accessRepo.save(access5);

        List<accessories> accessoriesList = new ArrayList<>();
        accessoriesList.add(access1);
        accessoriesList.add(access2);
        accessoriesList.add(access3);
        accessoriesList.add(access4);
        accessoriesList.add(access5);


        //In service, maybe?
       /* return accessoriesList
                .stream()
                .filter(accessories -> accessories.getAccessoriesRating() <= 5)
                .collect(Collectors.toList()); */
    }


//    @After
//    public void tearDown() {
//        accessRepo.deleteAll();
//        manuRepo.deleteAll();
//    }


}
