/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.purchaseweb.controller;

import domain.model.Purchase;
import domain.model.User;
import domain.model.UserRole;
import domain.rest.TestRest;
import domain.service.PurchasesService;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mauro
 */
@Controller
@RequestMapping(value = "/purchases")
public class PurchasesController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PurchasesService service;

    public PurchasesController(@Autowired PurchasesService service) {
        //this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPurchases() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = service.getUser(auth.getName());
        return new ModelAndView("allpurchases", "purchases", user.getPurchases());

    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView goAddPurchase() {
        return new ModelAndView("addpurchase", "purchase", new Purchase());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddPurchase(@Valid @ModelAttribute("purchase") Purchase purchase, BindingResult result) {
        if (result.hasErrors()) {
            return "addpurchase";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = service.getUser(auth.getName());
        purchase.setImageurl(service.createImageUrl(purchase));
        user.getPurchases().add(purchase);
        service.updateUser(user);
        return "redirect:/purchases.htm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView goEditPurchase(@PathVariable Long id) {
        Purchase purchase = service.getPurchase(id);
        return new ModelAndView("editpurchase", "purchase", purchase);
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.POST)
    public String processEditPurchase(@PathVariable Long id, @Valid @ModelAttribute("purchase") Purchase purchase, BindingResult result) {
        if (result.hasErrors()) {
            return "editpurchase";
        }
        purchase.setID(id);
        service.updatePurchase(purchase);
        return "redirect:/purchases.htm";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String processDeletePurchase(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = service.getUser(auth.getName());
        Purchase purchase = service.getPurchase(id);
        user.getPurchases().remove(purchase);
        service.updateUser(user);
        service.deletePurchase(purchase);
        return "redirect:/purchases.htm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView goRegister() {
        return new ModelAndView("register", "user", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        UserRole role = new UserRole();
        role.setRole("ROLE_USER");
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.addUser(user);
        return "redirect:/index.htm";
    }
//    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
//    public String login(){
//        return "login";
//    }
//    @RequestMapping(value="/processLogout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){    
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login";
//    }
//    @RequestMapping(value = "/loginError", method = RequestMethod.POST)
//    public String loginError(ModelMap model){
//        model.addAttribute("error", "true");
//        return "login";
//    }

}
