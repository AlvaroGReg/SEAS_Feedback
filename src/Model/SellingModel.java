/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author alvar
 */
public class SellingModel {
    
    int id_sell;
    String date;
    String buyerName;
    int buyerNumber;
    String productsBought;
    double totalPrice;

    public SellingModel(int id_sell, String date, String buyerName, int buyerNumber, String productsBought, double totalPrice) {
        this.id_sell = id_sell;
        this.date = date;
        this.buyerName = buyerName;
        this.buyerNumber = buyerNumber;
        this.productsBought = productsBought;
        this.totalPrice = totalPrice;
    }

    public SellingModel(String date, String buyerName, int buyerNumber, String productsBought, double totalPrice) {
        this.date = date;
        this.buyerName = buyerName;
        this.buyerNumber = buyerNumber;
        this.productsBought = productsBought;
        this.totalPrice = totalPrice;
    }

    public int getId_sell() {
        return id_sell;
    }

    public String getDate() {
        return date;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public int getBuyerNumber() {
        return buyerNumber;
    }

    public String getProductsBought() {
        return productsBought;
    }

    public double getTotalPrice() {
        return totalPrice;
    }   
}
