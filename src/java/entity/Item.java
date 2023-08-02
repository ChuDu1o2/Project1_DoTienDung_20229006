/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Zoro
 */
public class Item {
    private String name;
    private String image;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(String name, String image, int quantity, double price) {
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", image=" + image + ", quantity=" + quantity + ", price=" + price + '}';
    }

    
    
}
