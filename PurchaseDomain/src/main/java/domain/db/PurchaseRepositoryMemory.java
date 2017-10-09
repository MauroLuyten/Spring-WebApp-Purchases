/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;


import domain.model.Purchase;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

/**
 *
 * @author Mauro
 */
public class PurchaseRepositoryMemory implements PurchaseRepository{
    private static int counterID = 0;
    List< Purchase > purchases;

    public PurchaseRepositoryMemory() {
        purchases = new ArrayList<>();
        this.addPurchase(new Purchase(0, "Nexus 6P", "64GB", 699.99));
        this.addPurchase(new Purchase(1, "Pixel", "128GB", 749.99));
        
    }
    
    
    public PurchaseRepositoryMemory(List< Purchase> purchases) {
        this.purchases = purchases;
    }
    

    @Override
    public void addPurchase(Purchase purchase) {
        if(purchase==null){
            throw new DatabaseException("Purchase may not be null.");
        } else {
            purchase.setID(++counterID);
            purchases.add(purchase);
        }
    }

    @Override
    public Purchase getPurchase(Long purchaseID) {
        return purchases.get(purchaseID.intValue());
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchases;
    }

    @Override
    public void deletePurchase(Purchase purchase) {
        purchases.remove(purchase);
    }

    @Override
    public void updatePurchase(Purchase purchase) {
         if(purchase==null){
            throw new DatabaseException("Purchase may not be null.");
        } else{
             System.out.println();
             System.out.println(purchase.getTitle());
             this.purchases.remove(purchase);
         }
    }

    @Override
    public void close() {
       
    }

    @Override
    public void open() {
       
    }

//    @Override
//    public Long getPurchaseId(Purchase purchase) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
