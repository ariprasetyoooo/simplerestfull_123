/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.c.restfull_projects;

/**
 *
 * @author HAHAHA
 */
public class Product {
    private String id;
    private String name;
    private String qty;
    private String price;

    public String getQty() {
        return qty;
    }

    public void setQty(String Qty) {
        this.qty = Qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
