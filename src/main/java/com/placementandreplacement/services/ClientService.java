/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.services;

import com.placementandreplacement.entities.Client;
import com.placementandreplacement.repositories.ClientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author G551VW
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public Iterable<Client> getAll() {
        return repository.findAll();
    }

//    public Iterable<Department> findAllById(String id){
//        return repository.findAllById(id);
//    }
    public Optional<Client> getById(int id) {
        return repository.findById(id);
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public void delete(Client client) {
        repository.delete(client);
    }
}
