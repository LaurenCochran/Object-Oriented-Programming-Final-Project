
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lacf66moneymanager.SwitchScenes;



public class LoginPageController extends SwitchScenes implements Initializable{
    
    @FXML 
    Label welcomeLabel;
    
    @FXML 
    Label titleLabel;
    
    @FXML 
    Label errorLabel;
    
    @FXML
    ImageView loginImage1;
    
    @FXML
    ImageView loginImage2;
    
    @FXML
    TextField username;
    
    @FXML
    PasswordField password;
    
    @FXML
    Button loginButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    

    @FXML
    private void loginPress(ActionEvent event) {
        
        Boolean moveOnUsername = false;
        Boolean moveOnPassword = false;
        
         
        
        if(username.getText().length() < 1){
                errorLabel.setText("Username must be at least 1 character");
            }
            else { 
                moveOnUsername = true;
            }
            
        if(password.getText().length() < 1){
                errorLabel.setText("Password must be at least 1 character");
            }
            else {
                moveOnPassword = true;
            }
            
           if(moveOnUsername == true && moveOnPassword == true){
               SwitchScenes.switchTo("HomePageFXML");
           }


    }
  
}
