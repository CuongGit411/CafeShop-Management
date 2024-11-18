/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author TRI
 */
public class Menu {
    private int ID;
    private String drinkName;
    private int count;
    private int price;
    private int totalPrice;

    public Menu() {
    }

    public Menu(int ID,String drinkName, int count, int price, int totalPrice) {
        this.ID = ID;
        this.drinkName = drinkName;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    
    // Getter cho ID
    public int getID() {
        return ID;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
