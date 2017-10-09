/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.model.Purchase;
import domain.model.User;
import domain.model.UserRole;
import domain.service.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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

    private final PurchasesService service;

    public PurchasesController(@Autowired PurchasesService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPurchases() {
        return new ModelAndView("allpurchases", "purchases", service.getAllPurchases().values());

    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView goAddPurchase() {
        return new ModelAndView("addpurchase", "purchase", new Purchase());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String processAddPurchase(@ModelAttribute("purchase") Purchase purchase, BindingResult result){
        if(result.hasErrors()){
            return "addpurchase";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = service.getUser(auth.getName());
        service.addPurchase(purchase);
        long purchaseId = service.getPurchaseId(purchase);
        user.getPurchases().put(purchaseId, purchase);
        service.updateUser(user);
        return "redirect:/purchases.htm";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView goEditPurchase(@PathVariable Long id){
        return new ModelAndView("editpurchase", "purchase", service.getPurchase(id));
    }
    @RequestMapping(value = "/edit{id}", method = RequestMethod.POST)
    public String processEditPurchase(@PathVariable int id,@ModelAttribute("purchase") Purchase purchase, BindingResult result){
        if(result.hasErrors()){
            return "editpurchase";
        }
        purchase.setID(id);
        service.updatePurchase(purchase);
        return "redirect:/purchases.htm";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String processDeletePurchase(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = service.getUser(auth.getName());
        user.getPurchases().remove(id);
        service.updateUser(user);
        service.deletePurchase(id);
        return "redirect:/purchases.htm";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView goRegister(){
        return new ModelAndView("register", "user", new User());
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute("user") User user,BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        UserRole role = new UserRole();
        role.setRole("USER");
        user.getRoles().add(role);
        service.addUser(user);
        return "redirect:/index.htm";
    }

}
