/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.controllers;

import com.placementandreplacement.entities.Client;
import com.placementandreplacement.entities.Employee;
import com.placementandreplacement.entities.Interview;
import com.placementandreplacement.services.ClientService;
import com.placementandreplacement.services.EmployeeService;
import com.placementandreplacement.services.InterviewService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sandi1713
 */
@Controller
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ClientService clientService;

    @GetMapping("/interview")
    public String index(Model model) {
        model.addAttribute("employee", employeeService.getAll());
        model.addAttribute("client", clientService.getAll());
        model.addAttribute("interview", interviewService.getAll());
        model.addAttribute("addInterview", new Interview());
        return "interview";
    }

    @PostMapping("/interview/save")
    public String save(@RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "note") String note,
            @RequestParam(value = "client") int client,
            @RequestParam(value = "employee") String employee
    ) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date parsedDate = null;
        Date parsedTime = null;
        try {
            parsedDate = dateFormat.parse(date);
            parsedTime = timeFormat.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Interview interview = new Interview(parsedDate, parsedTime, note, new Client(client), new Employee(employee));
        interviewService.save(interview);
        return "redirect:/interview";
    }

    @GetMapping("/interview/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        interviewService.deleteById(id);
        return "redirect:/interview";
    }

    @PostMapping("/interview/edit")
    public String edit(@RequestParam(value = "id") int id,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "time") String time,
            @RequestParam(value = "note") String note,
            @RequestParam(value = "client") int client,
            @RequestParam(value = "employee") String employee
    ) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date parsedDate = null;
        Date parsedTime = null;
        try {
            parsedDate = dateFormat.parse(date);
            parsedTime = timeFormat.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Interview interview = new Interview( id,parsedDate, parsedTime, note, new Client(client), new Employee(employee));
        interviewService.save(interview);
        return "redirect:/interview";
    }

}
