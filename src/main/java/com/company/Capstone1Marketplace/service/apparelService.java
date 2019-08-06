package com.company.Capstone1Marketplace.service;


import com.company.Capstone1Marketplace.dao.apparelRepository;
import com.company.Capstone1Marketplace.dto.apparel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class apparelService {

    @Autowired
    private apparelRepository apparelRepo;

    public apparel addApparel(apparel apparel) {
        return apparelRepo.save(apparel);
    }

//    public List<apparel> getAllApparel() {
//        return apparelRepo.findAll();
//    }

    public apparel getApparelById(Integer apparelId) {return apparelRepo.getOne(apparelId);}

    public List<apparel> getApparelByName(String apparelName) {
        return apparelRepo.findByApparelName(apparelName);
    }

    public List<apparel> getApparelByQuantity(Integer apparelQuantity) {
        return apparelRepo.findByApparelQuantity(apparelQuantity);
    }

    public List<apparel> getApparelByRating(Integer apparelRating) {
        return apparelRepo.findByApparelRating(apparelRating);
    }

    // APPAREL RATED ABOVE 4
    public List<apparel> geApparelRatedAbove4(Integer apparelRating) {
        List<apparel> appList = apparelRepo.findByApparelRating(apparelRating)
                .stream()
                .filter(apparel -> apparel.getApparelRating() > 4)
                .collect(Collectors.toList());
        return appList;
    }

    public void updateApparel(apparel app, Integer apparelId) {
        if (app.getApparelId() != apparelId) {
            throw new IllegalArgumentException("Apparel ID must match the ID provided");
        }
        apparelRepo.save(app);
    }

    public void deleteApparel(Integer apparelId) {
        apparelRepo.deleteById(apparelId);
    }
}
