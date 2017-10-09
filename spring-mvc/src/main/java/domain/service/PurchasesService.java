/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.db.PurchaseRepository;
import domain.db.PurchaseRepositoryRelational;
import domain.db.RepositoryFactory;
import domain.db.UserRepository;
import domain.model.Purchase;
import domain.model.User;
import java.util.Map;

/**
 *
 * @author Mauro
 */
public class PurchasesService {

    private PurchaseRepository purchaseRepository;
    private UserRepository userRepository;

    public PurchasesService() {

    }

    public PurchasesService(String dbChoice) {
        RepositoryFactory factory = new RepositoryFactory(dbChoice);
        purchaseRepository = factory.getPurchaseRepo();
        purchaseRepository.open();
        userRepository = factory.getUserRepo();
        userRepository.open();

    }

    public void addPurchase(Purchase purchase) {
        purchaseRepository.addPurchase(purchase);
    }

    public Purchase getPurchase(Long purchaseID) {
        return purchaseRepository.getPurchase(purchaseID);
    }
    public Long getPurchaseId(Purchase purchase){
        return purchaseRepository.getPurchaseId(purchase);
    }

    public Map<Long, Purchase> getAllPurchases() {
        return purchaseRepository.getAllPurchases();
    }

    public void deletePurchase(Long purchaseID) {
        purchaseRepository.deletePurchase(purchaseID);
    }

    public void updatePurchase(Purchase purchase) {
        purchaseRepository.updatePurchase(purchase);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUser(String userId) {
        return userRepository.getUser(userId);
    }

    public Map<String, User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public double getTotalSpent() {
//        Map<Integer,Purchase> purchases = this.getAllPurchases();
//        double total = 0;
//        for (Purchase purchase : purchases) {
//            total += purchase.getPrice();
//        }
//        return total;
        return 0;
    }

    public Purchase getMostExpensivePurchase() {
//        List<Purchase> purchases = this.getAllPurchases();
//        Purchase purchasemax = new Purchase();
//        purchasemax.setPrice(0);
//        for (Purchase purchase : purchases) {
//            if (purchase.getPrice() > purchasemax.getPrice()) {
//                purchasemax = purchase;
//            }
//        }
//        return purchasemax;
        return null;
    }

    public void destroy() {
        this.purchaseRepository.close();
    }

}
