/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.ClientDBConnector;
import Model.Converter.ProductDBConnector;
import Model.Converter.SellingsDBConnector;
import Model.SellingModel;
import View.PanelNewSell;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class SellingsController {
    
    private PanelNewSell panel;
    private ProductDBConnector productDBConnector;
    private SellingsDBConnector sellingDBConnector;
    private ClientDBConnector clientsDBConnector;
    
    public SellingsController(PanelNewSell panel){
        this.panel=panel;
    }
    
    // Refresh table data
    public void refreshTable(){
        
        productDBConnector = new ProductDBConnector();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
            "Nombre", "Precio", "Cantidad*"}, 0);
        panel.getProductsTable().setModel(tableModel);
        panel.getjScrollPane2().setViewportView(panel.getProductsTable());
                
        for(int x = 0; x<productDBConnector.getProductsList().size(); x++){
            Vector tableRow = new Vector();
            
            tableRow.add(productDBConnector.getProductsList().get(x).getName());
            tableRow.add(productDBConnector.getProductsList().get(x).getPrice());
            tableModel.addRow(tableRow);
        }
    }
    
    //GETS FROM VIEW THE ID AND THE QUANTITY OF PRODUCTS AND NUMBER OF CLIENT TO SAVE IT IN SELLS HISTORY
    public void newBuy(){
        
        Double totalPrice = null;
        int phoneNumber = Integer.parseInt(panel.getTextField_buyerNumber().getText());
        
        //totalPrice = 
        
        SellingModel sellToAdd = new SellingModel(
                Date.valueOf(LocalDate.MAX),
                clientsDBConnector.getName(phoneNumber), 
                phoneNumber, 
                totalPrice);
        
        sellingDBConnector.newSell(sellToAdd);
        
    }
    
}