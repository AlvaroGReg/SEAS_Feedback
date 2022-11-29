/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB.Conexion;
import View.PanelClients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class ClientsController {
    
    private PanelClients panel;
    private DefaultTableModel tabla;
    private Connection conexion;
    private String id;
    
    public ClientsController(PanelClients panel){
        this.panel=panel;
    }
    
    // Refresh table data
    public void refreshTable(){
        try{    
        tabla = new DefaultTableModel(new String[]{
            "ID", "Nombre", "1ºApellido", "2ºApellido"}, 0);
        panel.getTable().setModel(tabla);
        panel.getScrPanel().setViewportView(panel.getTable());
        
        Conexion connect = new Conexion();
        conexion = connect.getConexion();
        Statement con = conexion.createStatement();
        ResultSet rs = con.executeQuery("SELECT * FROM Clientes");
        
        String nombre="";
        String ape1="";
        String ape2="";
        
        while(rs.next()){
            
            id=rs.getString(1);
            nombre=rs.getString(2);
            ape1=rs.getString(3);
            ape2=rs.getString(4);
            
            Vector filaTabla = new Vector();
            filaTabla.add(id);
            filaTabla.add(nombre);
            filaTabla.add(ape1);
            filaTabla.add(ape2);
            
            tabla.addRow(filaTabla);
        }
        
       }catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conexion != null){
                    conexion.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    //Shows data from selected row in EditTextField
    public void getSelectedRow(){
        
        DefaultTableModel tblModel=(DefaultTableModel) panel.getTable().getModel();
        id=tblModel.getValueAt(panel.getTable().getSelectedRow(), 0).toString();
        String tblNombre=tblModel.getValueAt(panel.getTable().getSelectedRow(), 1).toString();
        String tblApe1=tblModel.getValueAt(panel.getTable().getSelectedRow(), 2).toString();
        String tblApe2=tblModel.getValueAt(panel.getTable().getSelectedRow(), 3).toString();
        
        panel.getClientName().setText(tblNombre);
        panel.getPrename1().setText(tblApe1);
        panel.getPrename2().setText(tblApe2);
    }
    
    
    //Takes darta from EditText, updates DB and refresh table   
    public void editClient(){
        
        int idcliente=Integer.parseInt(id);
        DefaultTableModel tblModel=(DefaultTableModel) panel.getTable().getModel();
        
        if(panel.getTable().getSelectedRowCount()==1){
            
            String nombre=panel.getClientName().getText();
            String apellido_1=panel.getPrename1().getText();
            String apellido_2=panel.getPrename2().getText();
            
            try{
                Conexion conect=new Conexion();
                conexion=conect.getConexion();
                PreparedStatement consulta;
                consulta=conexion.prepareStatement("UPDATE Clientes SET nombre=?, Apellido1=?, Apellido2=? WHERE id_cliente="+ idcliente);
                consulta.setString(1, nombre);
                consulta.setString(2, apellido_1);
                consulta.setString(3, apellido_2);
                consulta.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                try{
                    if (conexion != null){
                        conexion.close();
                    }
                } catch (SQLException se){
                    se.printStackTrace();
                }
            }
            //NOT NECCESARY BUT EARLY TO ERASE
            tblModel.setValueAt(nombre, panel.getTable().getSelectedRow(), 1);
            tblModel.setValueAt(apellido_1, panel.getTable().getSelectedRow(), 2);
            tblModel.setValueAt(apellido_2, panel.getTable().getSelectedRow(), 3);
            
            JOptionPane.showMessageDialog(panel, "Modificación Realizada");
            refreshTable();
        } else{
            if (panel.getTable().getRowCount()==0){
                JOptionPane.showMessageDialog(panel, "La tabla esta vacia.");
            } else{
              JOptionPane.showMessageDialog(panel, "Por favor, seleccione una fila a modificar");
            }
        }
    }
    
    // Erases selected data from DB and table
    public void eraseClient(){
        
        int idcliente=Integer.parseInt(id);
        DefaultTableModel tblModel=(DefaultTableModel) panel.getTable().getModel();
        if(panel.getTable().getSelectedRowCount()==1){
        try{
            Conexion conect=new Conexion();
            conexion=conect.getConexion();
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("DELETE FROM Clientes WHERE id_cliente="+ idcliente);
            consulta.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (conexion != null){
                    conexion.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
            JOptionPane.showMessageDialog(panel, "Usuario eliminado");
        }else{
            if (panel.getTable().getRowCount()==0){
                JOptionPane.showMessageDialog(panel, "La tabla esta vacia.");
            } else{
              JOptionPane.showMessageDialog(panel, "Por favor, seleccione una fila a modificar");
            }
        }
        
        tblModel.removeRow(panel.getTable().getSelectedRow());
    }
    
    // Sends new data to DB
    public void newClient(String nombre, String apellido_1, String apellido_2){
        
        try{            
            Conexion conect=new Conexion();
            conexion=conect.getConexion();
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("INSERT INTO Clientes (nombre, apellido_1, apellido_2) VALUES (?,?,?)");
            consulta.setString(1, nombre);
            consulta.setString(2, apellido_1);
            consulta.setString(3, apellido_2);
            consulta.executeUpdate();
            
            JOptionPane.showMessageDialog(panel, "Usuario añadido ");
            refreshTable();
            
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            
            try{
                if (conexion != null){
                    conexion.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
    }
}