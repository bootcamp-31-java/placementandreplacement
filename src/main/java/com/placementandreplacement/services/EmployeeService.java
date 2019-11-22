/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.services;

import com.placementandreplacement.entities.Employee;
import com.placementandreplacement.repositories.EmployeeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G551VW
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Iterable<Employee> getAll() {
        return repository.findAll();
    }

//    public Iterable<Department> findAllById(String id){
//        return repository.findAllById(id);
//    }
    public Optional<Employee> getById(String id) {
        return repository.findById(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Employee employee) {
        repository.delete(employee);
    }
}
