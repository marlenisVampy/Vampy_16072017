/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tester;


import app.dataAccess.InterfazDal;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PC
 */
public class RLSoftFXMain extends Application {
    
   
   @Override
    public void start(Stage stage)throws Exception {
     /*   
       try
	  {
	  	
	  	InterfazDal.connectRLSoftDB();
	  	//InterfazDAL.crearUsuario(unU);
	  	InterfazDal.desconectar();
	  		InterfazDal.desconectar();
	  }catch(Exception e)
	  {
	  	System.out.println("Error: " + e.getMessage());
	  } 
        */
      Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
      Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.setTitle("RLSoft-Login v1.0");
    stage.setIconified(true);
    stage.setResizable(false);
    stage.show();        
        }
         
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
	 
        launch(args);
        
        
    }
    
 }
    