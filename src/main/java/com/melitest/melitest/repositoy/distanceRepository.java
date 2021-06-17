/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melitest.melitest.repositoy;

import com.melitest.melitest.model.distance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author trocha
 */
@Repository
public interface distanceRepository extends CrudRepository<distance,String> {
    
}
