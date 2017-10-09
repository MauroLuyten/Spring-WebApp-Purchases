/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Mauro
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
