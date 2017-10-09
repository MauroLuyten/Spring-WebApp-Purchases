/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Purchase;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
public class PurchaseRepositoryRelational implements PurchaseRepository{
    private EntityManagerFactory factory;
    private EntityManager manager;
    private String name;
    
    public void openConnection(){
        factory = Persistence.createEntityManagerFactory("IP_Purchases");
        manager = factory.createEntityManager();
    }
    public void closeConnection(){
        try {
            manager.close();
            factory.close();
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public void addPurchase(Purchase purchase) {
        manager.getTransaction().begin();
        manager.persist(purchase);
        manager.getTransaction().commit();
    }
    

    @Override
    public Purchase getPurchase(Long purchaseID) {
        return manager.find(Purchase.class, purchaseID);
    }

    @Override
    public Map<Long, Purchase> getAllPurchases() {
        Map<Long, Purchase> map = new HashMap<Long, Purchase>();
        Query query = manager.createQuery("SELECT c FROM purchases c");
        for (Purchase p : (Collection<Purchase>)query.getResultList()){
            map.put(p.getID(), p);
        }
        return map;
    }

    @Override
    public void deletePurchase(Long purchaseID) {
        manager.getTransaction().begin();
        manager.remove(this.getPurchase(purchaseID));
        manager.getTransaction().commit();
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        manager.getTransaction().begin();
        manager.merge(purchase);
        manager.getTransaction().commit();
    }

    @Override
    public void open() {
        this.openConnection();    
    }

    @Override
    public void close() {
        this.closeConnection();
    }

    @Override
    public Long getPurchaseId(Purchase purchase) {
        Purchase get= null;//
        Query query = manager.createQuery("select c from purchases c where c.price=:price and c.title=:title and c.description=:description")
                .setParameter("price", purchase.getPrice()).setParameter("title", purchase.getTitle()).setParameter("description", purchase.getDescription());
        get = (Purchase) query.getSingleResult();
        return get.getID();
        
    }
    
}
