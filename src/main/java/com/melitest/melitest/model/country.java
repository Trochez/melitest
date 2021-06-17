/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author trocha
 */
@RedisHash("country")
public class country implements Serializable{
    
    
    @Id
    private String alpha3Code;
    
    private String name;
    
    private language[] languages;
    
    private String[] timezones;
    
    private currency[] currencies;
    
    private float[] latlng;
    
    private float currencyPrice;
    
    private float BuenosAiresDistance;

    public float getBuenosAiresDistance() {
        return BuenosAiresDistance;
    }

    public void setBuenosAiresDistance(float BuenosAiresDistance) {
        this.BuenosAiresDistance = BuenosAiresDistance;
    }

    public float getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(float currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public language[] getLanguages() {
        return languages;
    }

    public void setLanguages(language[] languages) {
        this.languages = languages;
    }

    public String[] getTimezones() {
        return timezones;
    }

    public void setTimezones(String[] timezones) {
        this.timezones = timezones;
    }

    public currency[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(currency[] currencies) {
        this.currencies = currencies;
    }

    public float[] getLatlng() {
        return latlng;
    }

    public void setLatlng(float[] latlng) {
        this.latlng = latlng;
    }

    
    
    
    
}
