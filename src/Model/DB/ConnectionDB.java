package Model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alvar
 */
public class ConnectionDB {
    
    static final String DRIVER_JDBC="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/seas_javafinal";
    static final String USER="root";
    static final String PASS="";
    private Connection conn;
    
    public ConnectionDB() {
        conn=null;
        try{
            Class.forName(DRIVER_JDBC);
            conn=DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }  
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}