package Model.Converter;

import Model.ClientModel;
import Model.DB.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class ClientDBConnector {
    
    private Connection connection;
    
    //Returns an ArrayList filled with data inside "clientes" table
    public ArrayList<ClientModel> getClientsList(){
        
        ArrayList<ClientModel> clientsList = new ArrayList();
        
        try {
            ConnectionDB connect = new ConnectionDB();
            connection = connect.getConnection();
            Statement con;
            con = connection.createStatement();
            ResultSet rs = con.executeQuery("SELECT * FROM clientes");
            
            while(rs.next()){
                ClientModel nextClient = new ClientModel(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5),rs.getBoolean(6));
                clientsList.add(nextClient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBConnector.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        return clientsList;
    }
   
    //Updates data in table "productos"
    public void editClient(ClientModel clientToEdit){
        
        try {
           
            ConnectionDB connect = new ConnectionDB();
            connection = connect.getConnection();
            PreparedStatement query;
            
            query = connection.prepareStatement(
                    "UPDATE clientes SET nombre=?, apellido_1=?, apellido_2=?, telephone=?, vip=? "
                            + "WHERE id_cliente=" + clientToEdit.getId());
            
            query.setString(1, clientToEdit.getName());
            query.setString(2, clientToEdit.getPrename1());
            query.setString(3, clientToEdit.getPrename2());
            query.setInt(4, clientToEdit.getTelephone());
            query.setBoolean(5, clientToEdit.isVip());
            query.executeUpdate();
            
    } catch (SQLException ex) {
            Logger.getLogger(ProductDBConnector.class.getName()).log(
                    Level.SEVERE, null, ex);
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(new JFrame(), "Éste número de teléfono ya se ha asignado a una cuenta", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }

    // Erases selected data from DB and table
    public void deleteClient(int id_client){
        
        try{
            ConnectionDB conect=new ConnectionDB();
            connection=conect.getConnection();
            PreparedStatement consulta;
            
            consulta=connection.prepareStatement("DELETE FROM clientes WHERE id_cliente="+ id_client);
            consulta.executeUpdate();
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }        
    }   
    
     // Sends new data to DB
    public void newClient(ClientModel clientToAdd){
        
        try{            
            ConnectionDB conect = new ConnectionDB();
            connection = conect.getConnection();
            PreparedStatement query;
            
            query = connection.prepareStatement(
                    "INSERT INTO clientes (nombre, apellido_1, apellido_2, telefono, vip) VALUES (?,?,?,?,?)");            
            query.setString(1, clientToAdd.getName());
            query.setString(2, clientToAdd.getPrename1());
            query.setString(3, clientToAdd.getPrename2());
            query.setInt(4, clientToAdd.getTelephone());
            query.setBoolean(5, clientToAdd.isVip());
            query.executeUpdate();
           
        } catch (SQLException e){
            e.printStackTrace();
            if(e.getErrorCode()==1062){
                JOptionPane.showMessageDialog(new JFrame(), "Éste número de teléfono ya se ha asignado a una cuenta", "Error",
        JOptionPane.ERROR_MESSAGE);
            }    
            
        }finally {
            
            try{
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }    
}