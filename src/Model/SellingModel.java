/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author alvar
 */
public class SellingModel {
    
    int id_sell;
    Date date;
    String buyerName;
    int buyerNumber;
    double totalPrice;

    public SellingModel(int id_sell, Date date, String buyerName, int buyerNumber, double totalPrice) {
        this.id_sell = id_sell;
        this.date = date;
        this.buyerName = buyerName;
        this.buyerNumber = buyerNumber;
        this.totalPrice = totalPrice;
    }

    public SellingModel(Date date, String buyerName, int buyerNumber, double totalPrice) {
        this.date = date;
        this.buyerName = buyerName;
        this.buyerNumber = buyerNumber;
        this.totalPrice = totalPrice;
    }

    public int getId_sell() {
        return id_sell;
    }

    public Date getDate() {
        return date;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public int getBuyerNumber() {
        return buyerNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }   
}