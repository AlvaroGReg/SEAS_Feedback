/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DB.Conexion;
import View.PanelProducts;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class ProductsController {
    
    private PanelProducts panel;
    private DefaultTableModel table;
    private Connection conection;
    private String id;
    
    public ProductsController (PanelProducts panel){
        this.panel=panel;
    }
    
    // Refresh table data
    public void refreshTable(){
        try{   
            
        table = new DefaultTableModel(new String[]{
            "ID", "Nombre", "Precio"}, 0);
        panel.getProductsList().setModel(table);
        panel.getjScrollPane2().setViewportView(panel.getProductsList());
        
        Conexion conect=new Conexion();
        conection=conect.getConexion();
        Statement con=conection.createStatement();
        ResultSet rs=con.executeQuery("SELECT * FROM productos");
        
        int id = 0;
        String nombre="";
        int precio = 0;
        
        while(rs.next()){
            
            id = rs.getInt(1);
            nombre = rs.getString(2);
            precio = rs.getInt(3);
            
            Vector tableRow = new Vector();
            tableRow.add(id);
            tableRow.add(nombre);
            tableRow.add(precio);
            table.addRow(tableRow);
        }
        
       }catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conection != null){
                    conection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}
