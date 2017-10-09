/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Purchase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
public class PurchaseRepositoryRelational implements PurchaseRepository {

    private final EntityManagerFactory factory;
    private EntityManager manager;
    private String name;

    public PurchaseRepositoryRelational() {
        factory = Persistence.createEntityManagerFactory("IP_Purchases");
    }

    public void openConnection() {

        manager = factory.createEntityManager();
    }

    public void closeConnection() {
        try {
            manager.close();

        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public void addPurchase(Purchase purchase) {
        this.open();
        try {
            manager.getTransaction().begin();
            manager.persist(purchase);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public Purchase getPurchase(Long purchaseID) {
        this.open();
        Purchase purchase = manager.find(Purchase.class, purchaseID);
        this.closeConnection();
        return purchase;

    }

    @Override
    public List<Purchase> getAllPurchases() {
        this.open();
        List<Purchase> map = new ArrayList<>();
        Query query = manager.createQuery("SELECT c FROM purchases c");
        for (Purchase p : (Collection<Purchase>) query.getResultList()) {
            map.add(p);
        }
        this.closeConnection();
        return map;
    }

    @Override
    public void deletePurchase(Purchase purchase) {
        //deletePurchaseRelations(purchaseID);
        this.open();
        try {
            manager.getTransaction().begin();
            manager.remove(purchase);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            this.closeConnection();
        }

    }

//    public void deletePurchaseRelations(Long purchaseID){
//        manager.getTransaction().begin();
//        
//        Query query = manager.createQuery("select c from person_purchases c where c.purchases_key=:ID")
//                .setParameter("ID", purchaseID);
//        query.executeUpdate();
//    }
    @Override
    public void updatePurchase(Purchase purchase) {
        this.open();
        try {
            manager.getTransaction().begin();
            manager.merge(purchase);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void open() {
        this.openConnection();
    }

    @Override
    public void close() {
        factory.close();
        this.closeConnection();
    }

    @PreDestroy
    public void destruct() {
        factory.close();
    }

//    @Override
//    public Long getPurchaseId(Purchase purchase) {
//         Map<Long, Purchase> map = new HashMap<Long, Purchase>();
//        Query query = manager.createQuery("select c from purchases c where c.price=:price and c.title=:title and c.description=:description")
//                .setParameter("price", purchase.getPrice()).setParameter("title", purchase.getTitle()).setParameter("description", purchase.getDescription());
//        long get = query.setMaxResults(1).getFirstResult();
//        return get;
//        
//    }
}
