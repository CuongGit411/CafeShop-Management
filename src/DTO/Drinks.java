/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author huyparody
 */
public class Drinks {

    private int id;
    private String name;
    private int price;

    public Drinks() {
    }

    public Drinks(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Drinks(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    

    @Override
    public String toString() {
        return name;
    }

}
