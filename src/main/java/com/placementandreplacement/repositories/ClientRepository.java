/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.repositories;

import com.placementandreplacement.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author G551VW
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{
    
}
