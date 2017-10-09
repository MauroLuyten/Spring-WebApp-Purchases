/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.purchaserest.controller;

import domain.model.User;
import domain.service.PurchasesService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mauro
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UsersRestController {

    private final PurchasesService service;

    public UsersRestController(@Autowired PurchasesService service) {
        this.service = service;

    }
    @RequestMapping(method = RequestMethod.GET)
    public Map<String,User> getUsers(){
        return service.getAllUsers();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable String id){
        return service.getUser(id);
    }
    
}
