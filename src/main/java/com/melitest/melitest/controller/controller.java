/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.controller;

import com.melitest.melitest.model.country;
import com.melitest.melitest.model.updateDate;
import com.melitest.melitest.repositoy.updateDateRepository;
import com.melitest.melitest.service.countryService;
import com.melitest.melitest.service.distanceService;
import com.melitest.melitest.service.updateService;
import com.melitest.melitest.serviceImplementation.countryServiceImpl;
import com.melitest.melitest.serviceImplementation.updateServiceImpl;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trocha
 */
@RestController
public class controller {
    
    @Autowired
    private countryService cs;
    
    @Autowired
    private updateService us;
    
    @Autowired
    private distanceService ds;
    
    
    @GetMapping("/test")
    public String test(){
        
       return "test";
        
    }
    
    @GetMapping("/country")
    public country getCountruy(@RequestParam String ip){
        
        return cs.getCountryByIp(ip);
        
      
    }
    
    @GetMapping("/updateCountries")
    public String updateCountries(){
        
        if( us.updateData()){
            return "Countries updated successfully";
        }
        else{
            return "Countries not updated, the countries were already updated";
        }
        
      
    }
    
    @GetMapping("/maxDistance")
    public float getMaxDistance(){
        
        return ds.getMaxDistance();
        
      
    }
    
    @GetMapping("/minDistance")
    public float getMinDistance(){
        
        return ds.getMinDistance();
        
      
    }
    
    @GetMapping("/avrDistance")
    public float getAvrDistance(){
        
        return ds.getAverageDistance();
        
      
    }
    
    @DeleteMapping("/deleteAllDistances")
    public String removeAllDistance(){
         return ds.removeAllDistances();
    }
    
}
