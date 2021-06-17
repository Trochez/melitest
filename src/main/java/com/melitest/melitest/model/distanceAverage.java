/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author trocha
 */
@RedisHash("distanceAverage")
public class distanceAverage {
    
    @Id
    private String id;
    private float averageDistance;
    private long counter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAverageDistance() {
        return averageDistance;
    }

    public void setAverageDistance(float averageDistance) {
        
        this.averageDistance = averageDistance;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }
    
    public void addAverage(float newValue){
                
        this.averageDistance = this.averageDistance + (1.0f/(1.0f+(float)this.counter))*(newValue-this.averageDistance);
        this.counter++;
        
    }
    
    
}
