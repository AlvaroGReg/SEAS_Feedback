/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Converter;

import Model.Product;

/**
 *
 * @author alvar
 */
public class ProductConverter {
    
    public Product dbToObjet(int id, String name, int price){        
        Product newProduct = new Product(id, name, price);
        return newProduct;
    }
    
    public void ObjetToDBAdd(Product product){
        
    }
    
    public void ObjetToDBEdit(Product product){
        
    }
    public void ObjetToDBDelete(Product product){
        
    }
    
}
