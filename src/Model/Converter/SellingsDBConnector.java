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
public class SellingsDBConnector {
    
    private Connection connection;
    
    // Sends new data to DB
    public void newSell (SellingModel sellToAdd){
        
        try{            
            ConnectionDB conect = new ConnectionDB();
            connection = conect.getConnection();
            PreparedStatement query;
            
            query = connection.prepareStatement(
                    "INSERT INTO ventas (fecha, comprador_nombre, comprador_num, precio) VALUES (?,?,?,?)");            
            query.setDate(1, sellToAdd.getDate());
            query.setString(2, sellToAdd.getBuyerName());
            query.setInt(3, sellToAdd.getBuyerNumber());
            query.setDouble(4, sellToAdd.getTotalPrice());
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
        
    //Returns an ArrayList filled with data inside "Ventas" table
    public ArrayList<SellingModel> getSellsList(){
        
        ArrayList<SellingModel> sellsList = new ArrayList();
        
        try {
            ConnectionDB connect = new ConnectionDB();
            connection = connect.getConnection();
            Statement con;
            con = connection.createStatement();
            ResultSet rs = con.executeQuery("SELECT * FROM ventas");
            
            while(rs.next()){
                SellingModel nextSell = new SellingModel(
                        rs.getInt(1),
                        rs.getDate(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
                sellsList.add(nextSell);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellingsDBConnector.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        return sellsList;
    }
    
    // Erases selected data from DB and table
    public void deleteSell(int id_sell){
        
        try{
            ConnectionDB conect=new ConnectionDB();
            connection=conect.getConnection();
            PreparedStatement consulta;
            
            consulta=connection.prepareStatement("DELETE FROM ventas WHERE id_compra=" + id_sell);
            consulta.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
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