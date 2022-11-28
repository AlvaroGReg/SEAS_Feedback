package Controller;

import Model.DB.Conexion;
import View.BajaClientes;
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
public class AccionesBajaClientes {
    
    private BajaClientes panel;
    private Connection conexion;
    private DefaultTableModel tabla;
    private String id;
    
    public AccionesBajaClientes(BajaClientes panel){
        this.panel=panel; 
    }
    
    //Assigns ID
    
    public void getTableId(){
        DefaultTableModel tableModel=(DefaultTableModel) panel.getTable().getModel();
        id=tableModel.getValueAt(panel.getTable().getSelectedRow(), 0).toString();
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
    
    // Sets data on table
    
    public void refreshTable(){
                
        try{    
            tabla = new DefaultTableModel(new String[]{
                "ID" ,"Nombre", "1ºApellido", "2ºApellido"}, 0);
            panel.getTable().setModel(tabla);
            panel.getScrPanel().setViewportView(panel.getTable());
            Conexion conect=new Conexion();
            conexion=conect.getConexion();
            Statement con=conexion.createStatement();
            ResultSet rs=con.executeQuery("SELECT * FROM Clientes");
            String nombre="";
            String apellido_1="";
            String apellido_2="";
        while(rs.next()){
            id=rs.getString(1);
            nombre=rs.getString(2);
            apellido_1=rs.getString(3);
            apellido_2=rs.getString(4);
            Vector selectedRowVector = new Vector();
            selectedRowVector.add(id);
            selectedRowVector.add(nombre);
            selectedRowVector.add(apellido_1);
            selectedRowVector.add(apellido_2);
            tabla.addRow(selectedRowVector);
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
}