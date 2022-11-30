package Model.Converter;

import Model.DB.Conexion;
import Model.ProductModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class ProductDBConnector {
    
    private Connection connection;
    
    //Returns an ArrayList filled with data inside "productos" table
    public ArrayList<ProductModel> getProductsList(){
        
        ArrayList<ProductModel> productsList = new ArrayList();
        
        try {
            Conexion connect = new Conexion();
            connection = connect.getConexion();
            Statement con;
            con = connection.createStatement();
            ResultSet rs = con.executeQuery("SELECT * FROM productos");
            
            while(rs.next()){
                ProductModel nextProduct = new ProductModel(
                        rs.getInt(1), rs.getString(2), rs.getDouble(3));
                productsList.add(nextProduct);
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
        return productsList;
    }
    
    //Updates data in table "productos"
    public void editProduct(ProductModel product){
        
        try {
           
            Conexion connect = new Conexion();
            connection = connect.getConexion();
            PreparedStatement query;
            
            query = connection.prepareStatement(
                    "UPDATE productos SET nombre=?, precio=? "
                            + "WHERE id_producto=" + product.getId());
            query.setString(1, product.getName());
            query.setDouble(2, product.getPrice());
            query.executeUpdate();
            
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
    }
    
    // Erases selected data from DB and table
    public void deleteProduct(int id_product){
        
        try{
            Conexion conect=new Conexion();
            connection=conect.getConexion();
            PreparedStatement consulta;
            
            consulta=connection.prepareStatement("DELETE FROM productos WHERE id_producto="+ id_product);
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
    //TODO: Has tu return boolean to check if worked
    public void newProduct(ProductModel product){
        
        try{            
            Conexion conect = new Conexion();
            connection = conect.getConexion();
            PreparedStatement consulta;
            
            consulta = connection.prepareStatement("INSERT INTO productos (nombre, precio) VALUES (?,?)");            
            consulta.setString(1, product.getName());
            consulta.setDouble(2, product.getPrice());
            consulta.executeUpdate();
           
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
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
