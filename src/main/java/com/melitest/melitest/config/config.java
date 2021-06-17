/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.config;

import com.melitest.melitest.model.country;
import com.melitest.melitest.model.distance;
import com.melitest.melitest.model.distanceAverage;
import com.melitest.melitest.model.updateDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 * @author trocha
 */
@Configuration
public class config {
    
    @Bean
    public RedisTemplate<String, country> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, country> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    
    @Bean
    public RedisTemplate<String, updateDate> redisTemplateDate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, updateDate> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    
    @Bean
    public RedisTemplate<Integer, distance> redisTemplateDistance(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Integer, distance> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    
    @Bean
    public RedisTemplate<Integer, distanceAverage> redisTemplateDistanceAverage(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Integer, distanceAverage> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
