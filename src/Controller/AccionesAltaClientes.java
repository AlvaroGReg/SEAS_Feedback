package Controller;

import View.AltaClientes;
import Model.DB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class AccionesAltaClientes {
    
    private AltaClientes panel;
    private Connection conexion;
    
    public AccionesAltaClientes(AltaClientes panel){
        
        this.panel=panel;
        
    }
    
    // Sends new data to DB
    public void newClient(String nombre, String apellido_1, String apellido_2){
        
        try{            
            Conexion conect=new Conexion();
            conexion=conect.getConexion();
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("INSERT INTO Clientes (nombre, apellido_1, apellido_2) VALUES (?,?,?)");
            consulta.setString(1, nombre);
            consulta.setString(2, apellido_1);
            consulta.setString(3, apellido_2);
            consulta.executeUpdate();
            
            JOptionPane.showMessageDialog(panel, "Usuario añadido ");
            
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            
            try{
                if (conexion != null){
                    conexion.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
    }
    
}
