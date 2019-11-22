/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.services;

import com.placementandreplacement.entities.Interview;
import com.placementandreplacement.repositories.InterviewRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G551VW
 */
@Service
public class InterviewService {
    @Autowired
    private InterviewRepository repository;

    public Iterable<Interview> getAll() {
        return repository.findAll();
    }

//    public Iterable<Department> findAllById(String id){
//        return repository.findAllById(id);
//    }
    public Optional<Interview> getById(int id) {
        return repository.findById(id);
    }

    public Interview save(Interview interview) {
        return repository.save(interview);
    }

    public void delete(Interview interview) {
        repository.delete(interview);
    }
}
