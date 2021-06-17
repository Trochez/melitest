/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.receive;

import com.melitest.melitest.model.country;
import com.melitest.melitest.model.language;
import com.melitest.melitest.model.currency;
import java.io.Serializable;

/**
 *
 * @author trocha
 */
public class countryReceive implements Serializable{
    
    private String name;
    
    private String alpha3Code;
    
    private languageReceive[] languages;
    
    private String[] timezones;
    
    private currencyReceive[] currencies;
    
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

    public languageReceive[] getLanguages() {
        return languages;
    }

    public void setLanguages(languageReceive[] languages) {
        this.languages = languages;
    }

    public String[] getTimezones() {
        return timezones;
    }

    public void setTimezones(String[] timezones) {
        this.timezones = timezones;
    }

    public currencyReceive[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(currencyReceive[] currencies) {
        this.currencies = currencies;
    }

    public float[] getLatlng() {
        return latlng;
    }

    public void setLatlng(float[] latlng) {
        this.latlng = latlng;
    }
    
    public country toCountry(){
        
        language[] lg = new language[this.languages.length];
        currency[] cr = new currency[this.currencies.length];
        
        for(int i =0;i<this.languages.length;i++){
            lg[i] = new language( this.languages[i].getName());
        }
        
        for(int i =0;i<this.currencies.length;i++){
            cr[i] = new currency( this.currencies[i].getCode());
        }
        
        country c = new country();
        
        c.setAlpha3Code(alpha3Code);
        c.setCurrencies(cr);
        c.setLanguages(lg);
        c.setLatlng(latlng);
        c.setName(name);
        c.setTimezones(timezones);
        c.setCurrencyPrice(currencyPrice);
        c.setBuenosAiresDistance(BuenosAiresDistance);
        
        return c;
        
    }

    
}
