/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Mauro
 */
public class MyUserDetailsService implements UserDetailsService{

    private EntityManager entityManager;
    @PersistenceContext
    public void setEntityManager(EntityManager newEm){
        this.entityManager = newEm;
    }

    public UserDetails loadUserByUsername(String username){

        // assuming that you have a User class that implements UserDetails
       return  (UserDetails) entityManager.createQuery("from User where username = :username", User.class)
                            .setParameter("username", username)
                            .getSingleResult();
        

    }
}
