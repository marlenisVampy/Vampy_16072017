/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dataAccess;

import static java.lang.Class.forName;
import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import app.model.*;

import app.model.controller.*;
//import static app.model.controller.LoginViewController.txtMsgError;

/**
 *
 * @author PC
 */
public class InterfazDal {
    
   private static InterfazDal singleton;
   private static Connection connection;
   private static PreparedStatement stm; //real codigo aneudy,cambie a st de Statements
   private static ResultSet rs;
   private static int id = 0;
   
   private InterfazDal() throws ClassNotFoundException 
   {
         if (connection == null) {

            try {
                    Class.forName("org.sqlite.JDBC");
 connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\PC\\Desktop\\PruebaGit\\Vampy_16072017\\RLSoft\\src\\resources\\DataBase\\RLSoftDB.sqlite");
                 //No funciona Class.forName("org.apache.derby.jdbc.ClientDriver");
                  //DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
                  //connection = DriverManager.getConnection(url);

                if (connection != null) {
                    System.out.println("Conexión establecida... ");
                }

                      
              } catch (ClassNotFoundException|SQLException e){
                System.out.println("Exception de SQL : " + e.getMessage());
                e.printStackTrace();
            }
        
      }
    }
   
   public static Connection connectRLSoftDB() //ready
   {
       try {
            singleton = new InterfazDal();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return connection;
   }
   
   public static void desconectar()
   {
        try {
        // if(!connection.isClosed()){
            if(!connection.isClosed()){
                connection.close();
                System.out.println("Conexión cerrada... ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
   }
   /**--------------------------------Métodos Static---------------------------
    *
    * 
   */
    
   //ejecutarQuery

   public static ResultSet ejecutarQuery(String query, Object[] parametros)throws Exception{
        stm = connection.prepareStatement(query);

        if(parametros != null){
            for(int k = 0; k < parametros.length; k++){
                stm.setObject(k+1, parametros[k]);
            }
        }
       rs = stm.executeQuery();

        return rs;

    }//fin ejectarQuery()
   
    //autogenerar clave 
   public static int executeQueryGeneratedKeys(String query, Object [] parametros) throws Exception{  
        stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        if(parametros != null) {
            for(int k = 0; k < parametros.length; k++){
                stm.setObject(k+1, parametros[k]);
            }
        }
        
        stm.executeUpdate();
        rs = stm.getGeneratedKeys();
        
        while(rs.next()){
         id = rs.getInt(1);
        }
        stm.close();
        
        return id;
    } //fin método executeQueryGeneratedKeys()
}
   
    //ejecutar Insert
   //-----------------------------------------------------------------------
   /* public static Usuario leerUnUsuario(String nombreUsuario,String passWord)
   {
      Usuario usr = null; 

      try{
            
            ResultSet result; 
            Object[] parametros;       

            String selection = "SELECT userName,userPass"+
                               "FROM USUARIO" +
                               "WHERE userName = ? AND userPass = ?";

            parametros = new Object[]{nombreUsuario,passWord};
            
              

            InterfazDal.connectRLSoftDB();
            result = InterfazDal.ejecutarQuery(selection,parametros);

            if(result.next())
            {  
                               
                String noUsuario = result.getString("NombreUser");
                String passUsuario = result.getString("Pass");
                usr = new Usuario(noUsuario,passUsuario);   
                txtMsgError.setText("Login exitoso");
             }else
                 txtMsgError.setText("Los datos son incorrectos");              


         }catch(Exception error)
         {
            System.out.println("Error: " + error.getMessage());
         }finally
                {
                  return usr;
               }
   }//fin de leerUnUsuario()*/

