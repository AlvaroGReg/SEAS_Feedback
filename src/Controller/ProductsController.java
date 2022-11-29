/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Converter.ProductConverter;
import View.PanelProducts;
import java.util.Vector;
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
        panel.getProductsList().setModel(table);
        panel.getjScrollPane2().setViewportView(panel.getProductsList());
                
        for(int x = 0; x<converter.getProductsList().size(); x++){
            Vector tableRow = new Vector();
            tableRow.add(converter.getProductsList().get(x).getId());
            tableRow.add(converter.getProductsList().get(x).getName());
            tableRow.add(converter.getProductsList().get(x).getPrice());
            table.addRow(tableRow);
        }
    }
}