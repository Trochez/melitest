/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.serviceImplementation;

import com.melitest.melitest.client.client;
import static com.melitest.melitest.client.client.getCountryBasicInfo;
import com.melitest.melitest.model.country;
import com.melitest.melitest.model.distance;
import com.melitest.melitest.model.distanceAverage;
import com.melitest.melitest.receive.countryBasicReceive;
import com.melitest.melitest.repositoy.countryRepository;
import com.melitest.melitest.repositoy.distanceAverageRepository;
import com.melitest.melitest.repositoy.distanceRepository;
import com.melitest.melitest.service.countryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trocha
 */
@Service
public class countryServiceImpl implements countryService{
    
    @Autowired
    private countryRepository cr;
    
    @Autowired
    private distanceRepository dr;
    
    @Autowired
    private distanceAverageRepository dar;
    

    @Override
    public country getCountryByIp(String ip) {
        
        if(ip.contains(" ")){
            return null;
        }
        
        String[] partip = ip.split("\\.");
        
        if(partip.length<4){
            return null;
        }
        
        for(String part:partip){
            try{
                if(Integer.parseInt(part)<0){
                    return null;
                }
            }
            catch(Exception e){
                return null;
            }
        }
        
        countryBasicReceive cbr= getCountryBasicInfo(ip);
               
        Optional<country> optional = cr.findById(cbr.getCountryCode3());
        
        if(optional.isPresent()){
            
            country county = optional.get();
            
            Optional<distance> dmax = dr.findById("max");
            Optional<distance> dmin = dr.findById("min");
            Optional<distanceAverage> davr = dar.findById("avr");
            
            distanceAverage avr = new distanceAverage();
            distance max = new distance();
            distance min = new distance();
            
            if(dmax.isEmpty()){
                
                max.setId("max");
                max.setDistance(county.getBuenosAiresDistance());
                
            }
            else{
                
                max = dmax.get();
                                
                if(max.getDistance()<county.getBuenosAiresDistance()){
                    
                    max.setDistance(county.getBuenosAiresDistance());
                    
                }
                
            }
            
            if(dmin.isEmpty()){
                
                min.setId("min");
                min.setDistance(county.getBuenosAiresDistance());
                
                dr.save(min);
                
            }
            else{
                
                min = dmin.get();
                
                if(min.getDistance()>county.getBuenosAiresDistance()){
                    
                    min.setDistance(county.getBuenosAiresDistance());
                }
                
            }
            
            if(davr.isEmpty()){
                
                avr.setId("avr");
                avr.setAverageDistance(county.getBuenosAiresDistance());
                avr.setCounter(1);
                
            }
            else{
                
                avr = davr.get();
                avr.addAverage(county.getBuenosAiresDistance());
                
            }
            
            dar.save(avr);
            dr.save(max);
            dr.save(min);
            
            return county;
            
        }
        
        else{
            
            return null;
            
        }
        
        
    }
    
}
