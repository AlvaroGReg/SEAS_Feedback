/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClientModel;
import Model.Converter.ClientDBConnector;
import Model.Converter.ProductDBConnector;
import Model.Converter.SellingsDBConnector;
import Model.SellingModel;
import View.PanelNewSell;
import java.awt.Choice;
import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.IntStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    
    // Refresh table data and choice menu
    public void refreshTable(){
        
        productDBConnector = new ProductDBConnector();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
            "Nombre", "Precio", "Cantidad*"}, 0);
        panel.getProductsTable().setModel(tableModel);
        panel.getjScrollPane2().setViewportView(panel.getProductsTable());
        
        int[] nunmbers = IntStream.rangeClosed(0, 20).toArray();
                
        for(int x = 0; x<productDBConnector.getProductsList().size(); x++){
            Vector tableRow = new Vector();
            
            tableRow.add(productDBConnector.getProductsList().get(x).getName());
            tableRow.add(productDBConnector.getProductsList().get(x).getPrice());
            
            tableModel.addRow(tableRow);           
        } 
    }
    
    //Refresh choicer with phone, name and prename
    public void refreshChoicer(){
        
        clientsDBConnector = new ClientDBConnector();
        ArrayList<ClientModel> clientList = new ArrayList(clientsDBConnector.getClientsList());
        
        for(int x = 0; x < clientList.size(); x++){
            panel.getChoice_user().add(Integer.toString(clientList.get(x).getTelephone()) + " " + clientList.get(x).getName() + " " + clientList.get(x).getPrename1());
        }
    }
    
    //Calculates totalPrice of selected items
    public double calculateTotalPrice(){
        
        JTable tableForPrices = panel.getProductsTable();
        double totalPrice = 0;
        
        for(int x = 0; x < tableForPrices.getRowCount(); x++){
            try{
            totalPrice = totalPrice + (
                    Double.parseDouble(tableForPrices.getValueAt(x, 1).toString()) 
                    * Double.parseDouble(tableForPrices.getValueAt(x, 2).toString()));
            }catch(Exception e){       
            }            
        }
        return totalPrice;
    }
    
    //GETS FROM VIEW THE ID AND THE QUANTITY OF PRODUCTS AND NUMBER OF CLIENT TO SAVE IT IN SELLS HISTORY
    public void newBuy(){
        
        sellingDBConnector = new SellingsDBConnector();
        int phoneNumber = Integer.parseInt(panel.getChoice_user().getSelectedItem().replaceAll("[^0-9]", ""));

        double totalPrice = calculateTotalPrice();
        if (calculateTotalPrice()==0){
            JOptionPane.showMessageDialog(new JFrame(), "No se ha realizado una compra válida. Confirme los productos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;}
        
        if(clientsDBConnector.checkVIP(phoneNumber)){
        
            totalPrice = totalPrice - ( totalPrice / 20);
            JOptionPane.showMessageDialog(panel,
            "Se ha aplicado un descuento del 5%.");
        }

        
        SellingModel sellToAdd = new SellingModel(
                Date.valueOf(LocalDate.now()),
                clientsDBConnector.getName(phoneNumber), 
                phoneNumber, 
                totalPrice);
        
        sellingDBConnector.newSell(sellToAdd);      
    }   
}