/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.purchaseweb.config;

import domain.db.UserRepository;
import domain.model.UserRole;
import domain.service.PurchasesService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author mauro
 */
public class UserService implements UserDetailsService{
    
    @Autowired
    private PurchasesService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        domain.model.User systemUser= service.getUser(username);
        System.out.println(systemUser.getUserid());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(UserRole role:systemUser.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        org.springframework.security.core.userdetails.User u = new User(systemUser.getUserid(), systemUser.getPassword(),authorities );
        
        return u;
    }
    
}
