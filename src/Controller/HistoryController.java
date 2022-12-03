/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.SellingsDBConnector;
import View.PanelHistory;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class HistoryController {
    
    private PanelHistory panel;
    private SellingsDBConnector sellingsDBConector;    
        public HistoryController(PanelHistory panel){
        this.panel=panel;
    }
        
    // Refresh table data
    public void refreshTable(){
        
        sellingsDBConector = new SellingsDBConnector();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
            "ID", "Fecha", "Comprador", "Teléfono", "Coste"}, 0);
        panel.getTable_history().setModel(tableModel);
        panel.getjScrollPane2().setViewportView(panel.getTable_history());
                
        for(int x = 0; x<sellingsDBConector.getSellsList().size(); x++){
            Vector tableRow = new Vector();
            
            tableRow.add(sellingsDBConector.getSellsList().get(x).getId_sell());
            tableRow.add(sellingsDBConector.getSellsList().get(x).getDate());
            tableRow.add(sellingsDBConector.getSellsList().get(x).getBuyerName());
            tableRow.add(sellingsDBConector.getSellsList().get(x).getBuyerNumber());
            tableRow.add(sellingsDBConector.getSellsList().get(x).getTotalPrice());
            tableModel.addRow(tableRow);
        }
    }
    
    // Refresh table data with date filter
    public void refreshTableByDate(){
                
        String day = panel.getChoice_day().getSelectedItem();
        if(day.length()<2){day = "0" + day;}    
        String month = panel.getChoice_month().getSelectedItem();
        if(month.length()<2){month = "0" + month;}
        String year = panel.getChoice_year().getSelectedItem();
        
        String date = "\"" + year + "-" + month + "-" + day + "\"";
        
        sellingsDBConector = new SellingsDBConnector();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
            "ID", "Fecha", "Comprador", "Teléfono", "Coste"}, 0);
        panel.getTable_history().setModel(tableModel);
        panel.getjScrollPane2().setViewportView(panel.getTable_history());
                
        for(int x = 0; x<sellingsDBConector.getSellsByDate(date).size(); x++){
            Vector tableRow = new Vector();
            
            tableRow.add(sellingsDBConector.getSellsByDate(date).get(x).getId_sell());
            tableRow.add(sellingsDBConector.getSellsByDate(date).get(x).getDate());
            tableRow.add(sellingsDBConector.getSellsByDate(date).get(x).getBuyerName());
            tableRow.add(sellingsDBConector.getSellsByDate(date).get(x).getBuyerNumber());
            tableRow.add(sellingsDBConector.getSellsByDate(date).get(x).getTotalPrice());
            tableModel.addRow(tableRow);
        }
    }
    
    // Refresh table data with user filter
    public void refreshTableByUser(){
        
        int number = Integer.parseInt(panel.getTextField_phone().getText());
        
        sellingsDBConector = new SellingsDBConnector();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
            "ID", "Fecha", "Comprador", "Teléfono", "Coste"}, 0);
        panel.getTable_history().setModel(tableModel);
        panel.getjScrollPane2().setViewportView(panel.getTable_history());
                
        for(int x = 0; x<sellingsDBConector.getSellsByUser(number).size(); x++){
            Vector tableRow = new Vector();
            
            tableRow.add(sellingsDBConector.getSellsByUser(number).get(x).getId_sell());
            tableRow.add(sellingsDBConector.getSellsByUser(number).get(x).getDate());
            tableRow.add(sellingsDBConector.getSellsByUser(number).get(x).getBuyerName());
            tableRow.add(sellingsDBConector.getSellsByUser(number).get(x).getBuyerNumber());
            tableRow.add(sellingsDBConector.getSellsByUser(number).get(x).getTotalPrice());
            tableModel.addRow(tableRow);
        }
    }
    
    public void deleteItem(){           
        sellingsDBConector.deleteSell(getSelectedID());       
        refreshTable();
    }
    
    //Returns ID of selected row
    public int getSelectedID(){
        return Integer.parseInt(panel.getTable_history().getValueAt(
                panel.getTable_history().getSelectedRow(), 0).toString());
    }
}
