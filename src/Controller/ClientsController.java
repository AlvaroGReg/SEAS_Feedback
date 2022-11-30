package Controller;

import Model.ClientModel;
import Model.Converter.ClientDBConnector;
import View.PanelClients;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvar
 */
public class ClientsController {
    
    private PanelClients panel;
    private ClientDBConnector dbConnector;
    
    public ClientsController(PanelClients panel){
        this.panel=panel;
    }
    
    // Refresh table data
    public void refreshTable(){
        
        dbConnector = new ClientDBConnector();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{
            "ID", "Nombre", "Apellido", "Apellido2", "PIN"}, 0);
        panel.getTable().setModel(tableModel);
        panel.getScrPanel().setViewportView(panel.getTable());
                
        for(int x = 0; x<dbConnector.getClientsList().size(); x++){
            Vector tableRow = new Vector();
            tableRow.add(dbConnector.getClientsList().get(x).getId());
            tableRow.add(dbConnector.getClientsList().get(x).getName());
            tableRow.add(dbConnector.getClientsList().get(x).getPrename1());
            tableRow.add(dbConnector.getClientsList().get(x).getPrename2());
            tableRow.add(dbConnector.getClientsList().get(x).isVip());
            tableModel.addRow(tableRow);
        }
    }
    
    //Shows data from selected row in EditTextField
    public void writeSelectedRow(){
        
        DefaultTableModel tableModel =(DefaultTableModel) panel.getTable().getModel(); 
        
        panel.getTextView_clientName().setText(
            tableModel.getValueAt(panel.getTable().getSelectedRow(), 1).toString());
        panel.getTextView_prename1().setText(
            tableModel.getValueAt(panel.getTable().getSelectedRow(), 2).toString());
        panel.getTextView_prename2().setText(
            tableModel.getValueAt(panel.getTable().getSelectedRow(), 3).toString());
        panel.getCheckBox_vip().setSelected(
            (boolean)tableModel.getValueAt(panel.getTable().getSelectedRow(), 4));
    }
    
    //Takes data from EditText, updates DB and refresh table   
    public void editClient(){
            
            
            ClientModel editedClient = new ClientModel(
            getSelectedID(),        
            panel.getTextView_clientName().getText(),
            panel.getTextView_prename1().getText(),
            panel.getTextView_prename2().getText(),
            panel.getCheckBox_vip().isSelected());
            
            dbConnector.editClient(editedClient);                              
            refreshTable();                       
    } 
    
    //Communicates to connector to delete an item
    public void deleteClient(){        
        dbConnector.deleteClient(getSelectedID());
        refreshTable();
    }
    
    // Sends new data from panel to connector
    public void addProduct(){
                    
            ClientModel clientToAdd = new ClientModel(        
            panel.getTextView_clientName().getText(),
            panel.getTextView_prename1().getText(),
            panel.getTextView_prename2().getText(),
            panel.getCheckBox_vip().isSelected());

            dbConnector.newClient(clientToAdd);                              
            refreshTable();                                            
    }
    
    //Returns ID of selected row
    public int getSelectedID(){
        return Integer.parseInt(panel.getTable().getValueAt(
                panel.getTable().getSelectedRow(), 0).toString());
    }

    //Checks if name/prename String input is valid
    public boolean checkValidString(JTextField textFieldToCheck) {
        
      try{
        String stringForChecking = textFieldToCheck.getText();
        
        if(stringForChecking.length()>30){
            
            JOptionPane.showMessageDialog(panel,
                    "Nombre y/o apellido introducido es demasiado largo");        
            return false;  
            
        }else if(stringForChecking.length()<2){
            
            JOptionPane.showMessageDialog(panel,
                    "El nombre/apellido no puede ser menor de 2 carácteres");
            return false;
            
        }else{
            return true;
        }
      }catch(Exception e){
          JOptionPane.showMessageDialog(panel,
                    "Es obligatorio introducir nombre y apellidos");
          return false;
      }
    }
}