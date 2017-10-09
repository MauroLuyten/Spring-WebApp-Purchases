/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.purchaserest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Purchase;
import domain.model.User;
import domain.model.UserRole;
import domain.service.PurchasesService;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mauro
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/purchases")
public class PurchasesRestController {

    private final PurchasesService service;

    public PurchasesRestController(@Autowired PurchasesService service) {
        this.service = service;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List getPurchases() {
        return service.getAllPurchases();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Purchase getPurchase(@PathVariable long id) {
        return service.getPurchase(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPurchase(@RequestBody Purchase purchase) {
        service.addPurchase(purchase);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePurchases(@RequestBody List<Purchase> purchases) {
        service.getAllPurchases().addAll(purchases);
        for (Purchase purchase : purchases) {
            service.updatePurchase(purchase);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePurchase(@RequestBody Purchase purchase, @PathVariable long id) {
        Purchase old = service.getPurchase(id);
        if(old!=null){
        purchase.setID(id);
        service.getAllPurchases().add(purchase);
        service.updatePurchase(purchase);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePurchases() {
        for (User user : service.getAllUsers().values()) {
            user.getPurchases().clear();
            service.updateUser(user);
        }
        for (Purchase purchase : service.getAllPurchases()) {
            service.deletePurchase(purchase);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePurchase(@PathVariable long id) {
        Purchase purchase = service.getPurchase(id);
        if (purchase != null) {
            for (User user : service.getAllUsers().values()) {
                user.getPurchases().remove(purchase);
                service.updateUser(user);
            }
            service.deletePurchase(purchase);
        }
    }
}
