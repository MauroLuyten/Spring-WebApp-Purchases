/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.rest;

import java.util.List;

/**
 *
 * @author Mauro
 */

public class Result {
     private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> results) {
        this.items = results;
    }    
}
