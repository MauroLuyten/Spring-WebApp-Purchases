/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Lazy;


/**
 *
 * @author mauro
 */
@Entity(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "purchaseid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private double price;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userid")
//    private User owner;

    public Purchase (){
        
        
    }
    
    public Purchase(int ID, String title, String description, double price) {
        this.setID(ID);
        this.setTitle(title);
        this.setDescription(description);
        this.setPrice(price);
    }
    
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title==null||title.isEmpty()){
            throw new ModelException("Title may not be null/empty");
                    
        }
        else this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description==null||description.isEmpty()){
            throw new ModelException("Description may not be null/empty");
                    
        } else this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new ModelException("Price may not be Lower or equal to 0");
        }
        this.price = price;
    }
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }
    
}
