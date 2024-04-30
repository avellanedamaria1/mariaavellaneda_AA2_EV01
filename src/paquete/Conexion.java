
package paquete;

import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    
    private Conexion(){
        
    }
    
    private static Connection Conexion; 
    private static Conexion instancia;
    private static final String URL = "jdbc:mysql://localhost/bd_registros";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    
    public Connection Conectar(){
       try{
           
           Class.forName("com.mysql.jdbc.Driver");
           Conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
           
           JOptionPane.showMessageDialog(null,"Conexion exitosa");
           
             return Conexion;
       
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error : " +e) ;
       }
       return Conexion;
    } 
    public void cerrarConexion()throws SQLException{
        try{
             
            Conexion.close();
            JOptionPane.showMessageDialog(null, "Se desconecto de la base de datos . ");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error : " +e);
            Conexion.close();
        }finally{
            Conexion.close();
        }
    } 
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia; 
    }
    
}
