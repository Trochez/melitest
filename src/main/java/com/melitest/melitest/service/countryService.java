/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.service;

import com.melitest.melitest.model.country;

/**
 *
 * @author trocha
 */
public interface countryService {
    
    public country getCountryByIp(String ip);
    
}
