/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.services;

import com.placementandreplacement.entities.StatusAproval;
import com.placementandreplacement.repositories.StatusAprovalRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G551VW
 */
@Service
public class StatusAprovalService {

    @Autowired
    private StatusAprovalRepository repository;

    public Iterable<StatusAproval> getAll() {
        return repository.findAll();
    }

//    public Iterable<Department> findAllById(String id){
//        return repository.findAllById(id);
//    }
    public Optional<StatusAproval> getById(int id) {
        return repository.findById(id);
    }

    public StatusAproval save(StatusAproval statusAproval) {
        return repository.save(statusAproval);
    }

    public void delete(StatusAproval statusAproval) {
        repository.delete(statusAproval);
    }
}
