/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




/**
 *
 * @author mauro
 */
@Entity(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "purchaseid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column
    @NotNull(message = "{error.null.purchasetitle}")
    @Size(min = 1, message = "{error.size.purchasetitle}")
    private String title;
    @Column
    @NotNull(message = "{error.null.purchasedescription}")
    @Size(min = 1, message = "{error.size.purchasedescription}")
    private String description;
    @Column
    @NotNull(message = "{error.null.purchaseprice}")
    @Min(value = 0, message = "{error.min.purchaseprice}")
    private double price;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userid")
//    private User owner;
    @Column
    private String imageurl;

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
//        if(title==null||title.isEmpty()){
//            throw new ModelException("Title may not be null/empty");
//                    
//        }else
         this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
//        if(description==null||description.isEmpty()){
//            throw new ModelException("Description may not be null/empty");
//                    
//        } else 
            this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
//        if(price<=0){
//            throw new ModelException("Price may not be Lower or equal to 0");
//        }
        this.price = price;
    }
    
    
//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
   
    @Override
    public boolean equals(Object o){
        if(o instanceof Purchase){
            Purchase p = (Purchase) o;
            return p.getID()==this.getID();
        }
        else return false;
    }
    
}
