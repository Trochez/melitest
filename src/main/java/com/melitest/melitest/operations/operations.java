/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.operations;

import static com.melitest.melitest.constant.constant.BuenosAiresLocation;
import static com.melitest.melitest.constant.constant.earthRadiusKm;

/**
 *
 * @author trocha
 */
public class operations {
    
    public static float getDistance(float[] coordinates){
                
        if(coordinates.length == 0){
            return 0.0f;
        }
        
        float coo0 =(float) (coordinates[0]*Math.PI/180);
        float coo1 =(float) (coordinates[1]*Math.PI/180);
                
        float dlat = (float) (  coo0 -   BuenosAiresLocation[0]); 
        float dlong = (float) (  coo1 -   BuenosAiresLocation[1]); 
                
        float a = (float) (Math.sin(dlat/2) * Math.sin(dlat/2) + Math.sin(dlong/2) * Math.sin(dlong/2) * Math.cos(coo0) * Math.cos(BuenosAiresLocation[0]));
                
        float c = (float) (2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
                
        return earthRadiusKm*c;
        
    }
    
}
