/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Purchase;

import java.util.Map;

/**
 *
 * @author Mauro
 */
public interface PurchaseRepository {
    public void addPurchase(Purchase purchase);
    public Purchase getPurchase(Long purchaseID);
    public Map<Long,Purchase> getAllPurchases();
    public void deletePurchase(Long purchaseID);
    public void updatePurchase(Purchase purchase);
    public void open();
    public void close();
    public Long getPurchaseId(Purchase purchase);
    
}
