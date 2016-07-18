package com.github.rsallar.underevalprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.rsallar.underevalprj.domain.Client;
import com.github.rsallar.underevalprj.service.ClientService;

@RestController
public class ClientController {
    
    @Autowired
    ClientService service;

    @RequestMapping("/person")
    public Client person(@RequestParam(value="name", defaultValue="testname") String name) {
        
    	return service.findClient(name);
    }
    
    
    
}