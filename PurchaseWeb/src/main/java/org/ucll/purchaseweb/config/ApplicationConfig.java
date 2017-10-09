package org.ucll.purchaseweb.config;

import domain.service.PurchasesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mauro
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Bean(destroyMethod = "close")
    public PurchasesService service() {
        return new PurchasesService("relational");
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    

}
