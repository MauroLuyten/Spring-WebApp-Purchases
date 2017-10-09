/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.User;
import domain.model.Purchase;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mauro
 */
public class UserRepositoryRelational implements UserRepository{

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
    public void addUser(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }
    

    @Override
    public User getUser(String userID) {
        return manager.find(User.class, userID);
    }

    @Override
    public Map<String, User> getAllUsers() {
        Map<String, User> map = new HashMap<String, User>();
        Query query = manager.createQuery("SELECT c FROM Person c");
        for (User u : (Collection<User>)query.getResultList()){
            map.put(u.getUserid(), u);
        }
        return map;
    }

    @Override
    public void deleteUser(String userID) {
        manager.getTransaction().begin();
        manager.remove(this.getUser(userID));
        manager.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        manager.getTransaction().begin();
        manager.merge(user);
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
    
}
