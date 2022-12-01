/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Converter;

import Model.ClientModel;
import Model.DB.ConnectionDB;
import Model.SellingModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class SellingsDBConnector {
    
    private Connection connection;
    
    // Sends new data to DB
    public void newSell (SellingModel sellToAdd){
        
        try{            
            ConnectionDB conect = new ConnectionDB();
            connection = conect.getConnection();
            PreparedStatement query;
            
            query = connection.prepareStatement(
                    "INSERT INTO ventas (fecha, comprador_nombre, comprador_num, productos, precio) VALUES (?,?,?,?,?)");            
            query.setString(1, sellToAdd.getDate());
            query.setString(2, sellToAdd.getBuyerName());
            query.setInt(3, sellToAdd.getBuyerNumber());
            query.setString(4, sellToAdd.getProductsBought());
            query.setDouble(5, sellToAdd.getTotalPrice());
            query.executeUpdate();
           
        } catch (SQLException e){
            e.printStackTrace();           
        }finally {
            
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    } 
    
}
