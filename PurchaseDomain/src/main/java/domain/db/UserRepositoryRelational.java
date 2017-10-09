/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.User;
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
 * @author mauro
 */
public class UserRepositoryRelational implements UserRepository {

    private final EntityManagerFactory factory;
    private EntityManager manager;
    private String name;

    public void openConnection() {
        //factory = Persistence.createEntityManagerFactory("IP_Purchases");
        manager = factory.createEntityManager();
    }

    public UserRepositoryRelational() {
        factory = Persistence.createEntityManagerFactory("IP_Purchases");
    }

    public void closeConnection() {
        try {
            manager.close();

        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        this.open();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            this.closeConnection();
        }

    }

    @Override
    public User getUser(String userID) {
        this.open();
        User u = manager.find(User.class, userID);
        this.closeConnection();
        return u;
    }

    @Override
    public Map<String, User> getAllUsers() {
        this.open();
        Map<String, User> map = new HashMap<>();
        Query query = manager.createQuery("SELECT c FROM person c", User.class);

        List<User> users = query.getResultList();
        for (User user : users) {
            map.put(user.getUserid(), user);
        }
        this.closeConnection();
        return map;
    }

    @Override
    public void deleteUser(String userID) {
        this.open();

        try {
            manager.getTransaction().begin();
            manager.remove(this.getUser(userID));
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateUser(User user) {
        this.open();

        try {
            manager.getTransaction().begin();
            manager.merge(user);
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

}
