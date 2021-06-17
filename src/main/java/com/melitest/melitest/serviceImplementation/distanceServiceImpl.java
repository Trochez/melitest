/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.serviceImplementation;

import com.melitest.melitest.model.distance;
import com.melitest.melitest.model.distanceAverage;
import com.melitest.melitest.repositoy.distanceAverageRepository;
import com.melitest.melitest.repositoy.distanceRepository;
import com.melitest.melitest.service.distanceService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trocha
 */
@Service
public class distanceServiceImpl implements distanceService {
    
    @Autowired
    distanceRepository dr;
    
    @Autowired
    distanceAverageRepository dar;

    @Override
    public float getMaxDistance() {
        
        Optional<distance> dmax = dr.findById("max");
        
        if(dmax.isPresent()){
            return dmax.get().getDistance();
        }
        else{
            return 0.0f;
        }
        
    }

    @Override
    public float getMinDistance() {
        
        Optional<distance> dmin = dr.findById("min");
        
        if(dmin.isPresent()){
            return dmin.get().getDistance();
        }
        else{
            return 0.0f;
        }
    }

    @Override
    public float getAverageDistance() {
        
        Optional<distanceAverage> davr = dar.findById("avr");
        
        if(davr.isPresent()){
            return davr.get().getAverageDistance();
        }
        else{
            return 0.0f;
        }
    }

    @Override
    public String removeAllDistances() {
        
        dr.deleteAll();
        dar.deleteAll();
        return "Distances removed successfully";
    }
    
}
