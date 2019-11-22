/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.services;

import com.placementandreplacement.entities.Placement;
import com.placementandreplacement.repositories.PlacementRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G551VW
 */
@Service
public class PlacementService {

    @Autowired
    private PlacementRepository repository;

    public Iterable<Placement> getAll() {
        return repository.findAll();
    }

//    public Iterable<Department> findAllById(String id){
//        return repository.findAllById(id);
//    }
    public Optional<Placement> getById(int id) {
        return repository.findById(id);
    }

    public Placement save(Placement placement) {
        return repository.save(placement);
    }

    public void delete(Placement placement) {
        repository.delete(placement);
    }
}
