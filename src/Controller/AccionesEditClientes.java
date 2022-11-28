/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB.Conexion;
import View.EditClientes;
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
public class AccionesEditClientes {
    
    private EditClientes panel;
    private DefaultTableModel tabla;
    private Connection conexion;
    private String id;
    
    public AccionesEditClientes(EditClientes panel){
        this.panel=panel;
    }
    
    // Refresh table data
    
    public void NewTable(){
        try{    
        tabla = new DefaultTableModel(new String[]{
            "ID", "Nombre", "1ºApellido", "2ºApellido"}, 0);
        panel.getTable().setModel(tabla);
        panel.getScrPanel().setViewportView(panel.getTable());
        Conexion conect=new Conexion();
        conexion=conect.getConexion();
        Statement con=conexion.createStatement();
        ResultSet rs=con.executeQuery("SELECT * FROM Clientes");
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
        
        panel.getNombre().setText(tblNombre);
        panel.getApellido_1().setText(tblApe1);
        panel.getApellido_2().setText(tblApe2);
    }
    
    
    //Takes darta from EditText and updates in DB and table
    
    public void EditClient(){
        int idcliente=Integer.parseInt(id);
        DefaultTableModel tblModel=(DefaultTableModel) panel.getTable().getModel();
        if(panel.getTable().getSelectedRowCount()==1){
            
            String nombre=panel.getNombre().getText();
            String apellido_1=panel.getApellido_1().getText();
            String apellido_2=panel.getApellido_2().getText();
            
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
            
            tblModel.setValueAt(nombre, panel.getTable().getSelectedRow(), 1);
            tblModel.setValueAt(apellido_1, panel.getTable().getSelectedRow(), 2);
            tblModel.setValueAt(apellido_2, panel.getTable().getSelectedRow(), 3);
            
            JOptionPane.showMessageDialog(panel, "Modificación Realizada");
        } else{
            if (panel.getTable().getRowCount()==0){
                JOptionPane.showMessageDialog(panel, "La tabla esta vacia.");
            } else{
              JOptionPane.showMessageDialog(panel, "Por favor, seleccione una fila a modificar");
            }
        }
    }
}

