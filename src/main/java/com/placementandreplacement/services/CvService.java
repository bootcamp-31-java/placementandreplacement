/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.services;

import com.placementandreplacement.entities.Cv;
import com.placementandreplacement.repositories.CvRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G551VW
 */
@Service
public class CvService {
    @Autowired
    private CvRepository repository;

    public Iterable<Cv> getAll() {
        return repository.findAll();
    }

//    public Iterable<Department> findAllById(String id){
//        return repository.findAllById(id);
//    }
    public Optional<Cv> getById(int id) {
        return repository.findById(id);
    }

    public Cv save(Cv cv) {
        return repository.save(cv);
    }

    public void delete(Cv cv) {
        repository.delete(cv);
    }
}
