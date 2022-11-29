/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Converter;

import Model.DB.Conexion;
import Model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alvar
 */
public class ProductConverter {
    
    private Connection connection;
    
    public ArrayList<Product> getProductsList(){
        
        ArrayList<Product> productsList = new ArrayList();
        
        try {
            Conexion connect = new Conexion();
            connection = connect.getConexion();
            Statement con;
            con = connection.createStatement();
            ResultSet rs = con.executeQuery("SELECT * FROM productos");
            
            while(rs.next()){
                Product nextProduct = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
                productsList.add(nextProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductConverter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        return productsList;
    }
    
    public Product dbToObjet(int id, String name, int price){        
        Product newProduct = new Product(id, name, price);
        return newProduct;
    }
}
