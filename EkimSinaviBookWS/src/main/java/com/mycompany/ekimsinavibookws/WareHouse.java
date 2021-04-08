package com.mycompany.ekimsinavibookws;


import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    
    private int bookId;
    private float price;
    private List<Seller> sellers = new ArrayList<Seller>();
 
    public int getBookId() {
        return bookId;
    }
    public float getPrice() {
        return price;
    }
    
     public void setPrice(float price) {
        this.price = price;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
    
  
}
