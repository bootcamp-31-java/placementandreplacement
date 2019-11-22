/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.controllers;

import com.placementandreplacement.entities.Client;
import com.placementandreplacement.entities.Employee;
import com.placementandreplacement.services.ClientService;
import com.placementandreplacement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sandi1713
 */
@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/client")
    public String index(Model model) {
        model.addAttribute("rm", employeeService.getAll());
        model.addAttribute("client", clientService.getAll());
        model.addAttribute("addclient", new Client());
        return "client";
    }

    @PostMapping("/client")
    public String save(Model model, Client client) {
        model.addAttribute("addclient", clientService.save(client));
        return "redirect:/client";
    }

    @GetMapping("/client/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {

        clientService.deleteById(id);
        return "redirect:/client";
    }

    @GetMapping("/client/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("idclient", clientService.getById(id));
        return "client";
    }

}
