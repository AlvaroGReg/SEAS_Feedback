/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.ProductConverter;
import Model.Product;
import View.PanelProducts;
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
    
    //Takes data from EditText, updates DB and refresh table   
    public void editClient(){
                
        if(panel.getProductsTable().getSelectedRowCount()==1){
            
            Product editedProduct = new Product(
            (int) panel.getProductsTable().getValueAt(panel.getProductsTable().getSelectedRow(),1),        
            panel.getTextfield_name().toString(),
            Double.parseDouble(panel.getTextField_price().toString()));
            
            converter.editProduct(editedProduct);                   
            
            JOptionPane.showMessageDialog(panel, "Modificación Realizada");
            refreshTable();
        } else{
            if (panel.getProductsTable().getRowCount()==0){
                JOptionPane.showMessageDialog(panel, "La tabla esta vacia.");
            } else{
              JOptionPane.showMessageDialog(panel,
                      "Por favor, seleccione una fila a modificar");
            }
        }
    } 
}