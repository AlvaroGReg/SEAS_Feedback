/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.ProductDBConnector;
import Model.ProductModel;
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
    private ProductDBConnector dbConnector;
    
    public ProductsController (PanelProducts panel){
        this.panel=panel;
    }
    
    // Refresh table data
    public void refreshTable(){
        
        dbConnector = new ProductDBConnector();
        table = new DefaultTableModel(new String[]{
            "ID", "Nombre", "Precio"}, 0);
        panel.getTable().setModel(table);
        panel.getjScrollPane2().setViewportView(panel.getTable());
                
        for(int x = 0; x<dbConnector.getProductsList().size(); x++){
            Vector tableRow = new Vector();
            tableRow.add(dbConnector.getProductsList().get(x).getId());
            tableRow.add(dbConnector.getProductsList().get(x).getName());
            tableRow.add(dbConnector.getProductsList().get(x).getPrice());
            table.addRow(tableRow);
        }
    }
    
    //Shows data from selected row in EditTextField
    public void writeSelectedRow(){
        
        DefaultTableModel tableModel=(DefaultTableModel) panel.getTable().getModel();        
        panel.getTextfield_name().setText(tableModel.getValueAt(panel.getTable().getSelectedRow(), 1).toString());
        panel.getTextField_price().setText(String.valueOf(tableModel.getValueAt(panel.getTable().getSelectedRow(), 2)));
    }
    
    //Takes data from EditText, updates DB and refresh table   
    public void editProduct(){
                 
            ProductModel editedProduct = new ProductModel(
            getSelectedID(),        
            panel.getTextfield_name().getText(),
            Double.parseDouble(panel.getTextField_price().getText()));

            dbConnector.editProduct(editedProduct);                              
            refreshTable();       
    } 
    
    // Erases selected data from DB and table
    public void deleteProduct(){        
        dbConnector.deleteProduct(getSelectedID());
        refreshTable();
    }
    
    // Sends new data from panel to converter
    public void addProduct(){
        
        ProductModel newProduct = new ProductModel(       
        panel.getTextfield_name().getText(),
        Double.parseDouble(panel.getTextField_price().getText()));                    
        dbConnector.newProduct(newProduct);
        refreshTable();
    }
    
    //Returns ID of selected row
    public int getSelectedID(){

        return Integer.parseInt(panel.getTable().getValueAt(
                panel.getTable().getSelectedRow(), 0).toString());
    }
    
    //Checks if price has a valid number
    public boolean checkValidPrice(){
        try{
            double priceForChecking = Double.parseDouble(
                panel.getTextField_price().getText());

            if(priceForChecking<=0){
                
                JOptionPane.showMessageDialog(
                    panel, "Introduzca un precio mayor que cero");
                return false;
                
            }else if(priceForChecking>999){
                
                JOptionPane.showMessageDialog(
                    panel, "Precio introducido demasiado alto (max.999)");
                return false;
            }else{  
                
                return true;
            }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(panel,
                    "Introduzca un valor numérico en la casilla de precio");        
            return false;
        }
    }

    //Checks if name input is valid
    public boolean checkValidName() {
        
      try{
        String nameForChecking = panel.getTextfield_name().getText();
        
        if(nameForChecking.length()>30){
            JOptionPane.showMessageDialog(panel,
                    "El nombre introducido es demasiado largo");        
            return false;   
        }else if(nameForChecking.length()<3){
            
            JOptionPane.showMessageDialog(panel,
                    "El nombre del producto no puede ser menor de 3 carácteres");
            return false;
        }else{
            return true;
        }
      }catch(Exception e){
          JOptionPane.showMessageDialog(panel,
                    "Rellene la casilla de nombre");
          return false;
      }
    }
}