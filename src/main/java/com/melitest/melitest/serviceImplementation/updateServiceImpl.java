/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.serviceImplementation;

import static com.melitest.melitest.client.client.getAllCountries;
import static com.melitest.melitest.client.client.getAllCurrencies;
import com.melitest.melitest.model.updateDate;
import com.melitest.melitest.receive.countryReceive;
import com.melitest.melitest.receive.currenciesReceive;
import com.melitest.melitest.repositoy.countryRepository;
import com.melitest.melitest.repositoy.updateDateRepository;
import com.melitest.melitest.service.updateService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static com.melitest.melitest.operations.operations.getDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trocha
 */
@Service
public class updateServiceImpl implements updateService{
    
    @Autowired
    private updateDateRepository udr;
    
    @Autowired
    private countryRepository cr;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public boolean updateData() {
        
        updateDate lastUpdate = null;

        Optional<updateDate> updateDateOp = udr.findById("1");
        
        if(updateDateOp.isEmpty()){
            LocalDate yesterday = LocalDate.now().minusDays(1);
            
            lastUpdate = new updateDate("1",Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        else{
            lastUpdate = updateDateOp.get();
        }

            
        Date date = new Date();
        
        int actualdate = date.getYear()*10000+date.getMonth()*100+date.getDate();
        int lastdate = lastUpdate.getUpdateDate().getYear()*10000+ lastUpdate.getUpdateDate().getMonth()*100+ lastUpdate.getUpdateDate().getDate();
                
        
        if(actualdate>lastdate){
            
            countryReceive[] countries = getAllCountries();
            currenciesReceive cur = getAllCurrencies();
            
            
            List<countryReceive> countriesList = Arrays.asList(countries);
            
            lastUpdate.setUpdateDate(date);
            udr.save(lastUpdate);
            
            countriesList.parallelStream().forEach(crv -> {
                
                if(cur.getRates().get(crv.getCurrencies()[0].getCode()) == null){
                    
                    crv.setCurrencyPrice(0.0f);
                                        
                }
                else{
                                        
                    crv.setCurrencyPrice(cur.getRates().get(crv.getCurrencies()[0].getCode()));
                    
                }
                
                if(crv.getLatlng().length <2){
                                        
                    crv.setBuenosAiresDistance(0.0f);
                    
                }
                else{
                                                   
                    crv.setBuenosAiresDistance(getDistance(crv.getLatlng()));
                    
                }
                
                cr.save(crv.toCountry());
                
                
            });
                        
            return true;
            
        }
        
        else {
            return false;
        }
        
    }
    
}
