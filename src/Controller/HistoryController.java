/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.ProductDBConnector;
import Model.Converter.SellingsDBConnector;
import View.PanelHistory;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
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
    public void deleteItem(){   
        
        JTable table = panel.getTable_history();

        sellingsDBConector.deleteSell((int)table.getValueAt(table.getSelectedColumn(), 0));
        
        refreshTable();
    }
}
