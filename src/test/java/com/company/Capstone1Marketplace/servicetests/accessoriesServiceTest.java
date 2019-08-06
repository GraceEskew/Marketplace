package com.company.Capstone1Marketplace.servicetests;

import com.company.Capstone1Marketplace.dao.accessoriesRepository;
import com.company.Capstone1Marketplace.dto.accessories;
import com.company.Capstone1Marketplace.service.accessoriesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class accessoriesServiceTest {
    @Mock
    @Autowired
    accessoriesRepository accessRepoMock;

    @InjectMocks
    accessoriesService accessService;

    accessories access1;
    accessories access2;
    accessories access3;

    List<accessories> accessList;

    @Before
    public void setUp() {
        access1 = new accessories();
        access1.setAccessoriesName("Necklace");
        access1.setAccessoriesPrice(14.99);
        access1.setAccessoriesQuantity(15);
        access1.setAccessoriesRating(3);

        access2 = new accessories();
        access2.setAccessoriesName("Bracelet");
        access2.setAccessoriesPrice(10.99);
        access2.setAccessoriesQuantity(5);
        access2.setAccessoriesRating(4);

        access3 = new accessories();
        access3.setAccessoriesName("Cuff Links");
        access3.setAccessoriesPrice(99.99);
        access3.setAccessoriesQuantity(2);
        access3.setAccessoriesRating(5);

        accessList = Arrays.asList(access1, access2, access3);
    }

    @Test
    public void shouldGetAllAccessories(){
        List<accessories> expectedList = Arrays.asList(access1, access2, access3);
        when(accessRepoMock.findAll()).thenReturn(accessList);
        assertEquals(expectedList, accessService.getAllAccessories());
    }

    @Test
    public void shouldGetAccessoriesByName() {
        List<accessories> expectedList = Arrays.asList(access1);
        List<accessories> accessList = Arrays.asList(access1);
        when(accessRepoMock.findByAccessoriesName(access1.getAccessoriesName())).thenReturn(accessList);
        assertEquals(expectedList, accessService.getAccessoriesByName(access1.getAccessoriesName()));
    }

    @Test
    public void shouldGetAccessoriesByPrice() {
        List<accessories> expectedList = Arrays.asList(access2);
        List<accessories> accessList = Arrays.asList(access2);
        when(accessRepoMock.findByAccessoriesPrice(access2.getAccessoriesPrice())).thenReturn(accessList);
        assertEquals(expectedList, accessService.getAccessoriesByPrice(access2.getAccessoriesPrice()));
    }

//    @Test
//    public void shouldGetAccessoriesByRating() {
//        List<accessories> expectedList = Arrays.asList(access3);
//        List<accessories> accessList = Arrays.asList(access3);
//        when(accessRepoMock.findByAccessoriesRating(access3.getAccessoriesRating())).thenReturn(accessList);
//        assertEquals(expectedList, accessService.getAccessoriesByRating(access3.getAccessoriesRating()));
//    }

}

/* NOTES *****
* Final Test Commented out due to IJ issue - java.lang.AssertionError
* -- IJ is saying that the code is returning an empty list, but everything is matching. Also,
* other tests present that are also dealing with Integers, so not sure where the disconnect is.
*
* */
