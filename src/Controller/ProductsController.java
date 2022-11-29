/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.ProductConverter;
import Model.DB.Conexion;
import View.PanelProducts;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class ProductsController {
    
    private PanelProducts panel;
    private DefaultTableModel table;
    private ProductConverter converter;
    
    public ProductsController (PanelProducts panel){
        this.panel=panel;
    }
    
    // Refresh table data
    public void refreshTable(){
        
        converter = new ProductConverter();
        table = new DefaultTableModel(new String[]{
            "ID", "Nombre", "Precio"}, 0);
        panel.getProductsTable().setModel(table);
        panel.getjScrollPane2().setViewportView(panel.getProductsTable());
                
        for(int x = 0; x<converter.getProductsList().size(); x++){
            Vector tableRow = new Vector();
            tableRow.add(converter.getProductsList().get(x).getId());
            tableRow.add(converter.getProductsList().get(x).getName());
            tableRow.add(converter.getProductsList().get(x).getPrice());
            table.addRow(tableRow);
        }
    }
    
    //Shows data from selected row in EditTextField
    public void getSelectedRow(){
        
        DefaultTableModel tableModel=(DefaultTableModel) panel.getProductsTable().getModel();
        
        String name = tableModel.getValueAt(panel.getProductsTable().getSelectedRow(), 1).toString();
        double price = (double) tableModel.getValueAt(panel.getProductsTable().getSelectedRow(), 2);
        
        panel.getTextfield_name().setText(name);
        panel.getTextField_price().setText(String.valueOf(price));
    }
    
       //Takes darta from EditText, updates DB and refresh table   
    public void editClient(){
        
        int idcliente=Integer.parseInt(id);
        DefaultTableModel tblModel=(DefaultTableModel) panel.getTable().getModel();
        
        if(panel.getTable().getSelectedRowCount()==1){
            
            String nombre=panel.getClientName().getText();
            String apellido_1=panel.getPrename1().getText();
            String apellido_2=panel.getPrename2().getText();
            
           
            
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
}