/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.client;

import com.melitest.melitest.receive.countryBasicReceive;
import com.melitest.melitest.receive.countryReceive;
import com.melitest.melitest.receive.currenciesReceive;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author trocha
 */
public class client {
    
    public static countryBasicReceive getCountryBasicInfo(String ip)
    {
        
        final String uri = "https://api.ip2country.info/ip?"+ip;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<countryBasicReceive> response = restTemplate.getForEntity(uri, countryBasicReceive.class);
        
        return response.getBody();

    }
    
    public static countryReceive[]  getAllCountries()
    {
        
        final String uri = "https://restcountries.eu/rest/v2/all";

        RestTemplate restTemplate = new RestTemplate();

        countryReceive[] response = restTemplate.getForEntity(uri, countryReceive[].class).getBody();
        
        return response;
        

    }
    
    
    public static currenciesReceive getAllCurrencies()
    {
        
        final String uri = "http://data.fixer.io/api/latest?access_key=5eb33e5605ec8555b0cc7ce255929675&format=1l";

        RestTemplate restTemplate = new RestTemplate();

        currenciesReceive response = restTemplate.getForEntity(uri, currenciesReceive.class).getBody();
        
        return response;
        

    }
    
    
    
}
