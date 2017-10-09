/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Purchase;
import java.util.List;

import java.util.Map;

/**
 *
 * @author Mauro
 */
public interface PurchaseRepository {
    public void addPurchase(Purchase purchase);
    public Purchase getPurchase(Long purchaseID);
    public List<Purchase> getAllPurchases();
    public void deletePurchase(Purchase purchase);
    public void updatePurchase(Purchase purchase);
    public void open();
    public void close();
//    public Long getPurchaseId(Purchase purchase);
    
}
