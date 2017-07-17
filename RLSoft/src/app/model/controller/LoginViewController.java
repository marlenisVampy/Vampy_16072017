/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model.controller;

import app.dataAccess.InterfazDal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class LoginViewController implements Initializable {

    InterfazDal Dal;
    PreparedStatement pSt = null;
    ResultSet rs = null;
      

    @FXML
    public Label txtMsgError;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button btnOK;

    @FXML
    private void verifyUserData(ActionEvent e) throws Exception {

        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    
      String query = "SELECT userName,userPass FROM Login WHERE userName =? AND userPass =?";
                                          
                      // InterfazDal.connectRLSoftDB();
                    pSt = Dal.connectRLSoftDB().prepareStatement(query);
                    pSt.setString(1, txtUser.getText());
                    pSt.setString(2, txtPass.getText());
                    rs = pSt.executeQuery();
                    
                    while(rs.next())
                    {
                        if (rs.next()) {
                        txtMsgError.setText("Login Successful");
                         System.out.println("Estoy dentro1");
                    }else {
                        txtMsgError.setText("Login Failed");
                         System.out.println("Estoy dentro2");
                    }
                    }
                    
                   
                                  
                    pSt.close();
                    rs.close();

                } catch (Exception sqlE) {
                   // txtMsgError.setText("SQL Failed");
                    System.out.println("Exception de SQL : " + sqlE.getMessage());
                }
            }

         });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
        /*
@FXML
public void verifyUserData(ActionEvent e)
    {
        try{
        String query = "SELECT userName,userPass FROM USUARIO WHERE userName = ? AND userPass = ?";
        pSt= conn.prepareStatement(query);
        pSt.setString(1,txtUser.getText());
        pSt.setString(2,txtPass.getText());
        rs = pSt.executeQuery();
        if(rs.next())
        {
            txtMsgError.setText("Login Successful");
        }else
             txtMsgError.setText("Login Failed");
      
        pSt.close();
        rs.close();
        
        }catch(SQLException sqlE)
        {
         System.out.println("Exception de SQL : " +  sqlE.getMessage());
        }
                }
                         
            })     
          
   
/*
@FXML
public void verifyUserData(ActionEvent e)
    {
        try{
        String query = "SELECT userName,userPass FROM USUARIO WHERE userName = ? AND userPass = ?";
        pSt= conn.prepareStatement(query);
        pSt.setString(1,txtUser.getText());
        pSt.setString(2,txtPass.getText());
        rs = pSt.executeQuery();
        if(rs.next())
        {
            txtMsgError.setText("Login Successful");
        }else
             txtMsgError.setText("Login Failed");
      
        pSt.close();
        rs.close();
        
        }catch(SQLException sqlE)
        {
         System.out.println("Exception de SQL : " +  sqlE.getMessage());
        } */
            
        
                 
                    /*Object[] parametros;  
                    
                    String query = "SELECT userName,userPass FROM USUARIO WHERE userName = ? AND userPass = ?";
                    
                    parametros = new Object[]{userName,userPass};
                    InterfazDal.connectRLSoftDB();
                    rs = InterfazDal.ejecutarQuery(query,parametros);
                    
                     if (rs.next()) {
                        txtMsgError.setText("Login Successful");
                         System.out.println("Estoy dentro1");
                    }else {
                        txtMsgError.setText("Login Failed");
                         System.out.println("Estoy dentro2");
                    }*/
   
