/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placementandreplacement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author G551VW
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String Home() {
        
        return "home";
    }
    
//    @GetMapping("/*")
//    public String error() {
//        return "404";
//    }
}
