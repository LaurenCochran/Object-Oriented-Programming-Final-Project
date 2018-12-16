
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lacf66moneymanager.SwitchScenes;

public class HomePageController extends SwitchScenes implements Initializable {

    @FXML
    Button aboutButton;
    
    @FXML
    Button startButton;
    
    @FXML
    Button exitButton;
    
    @FXML
    Button dIYButton;
    
    @FXML
    private void goToAbout(ActionEvent event){
        SwitchScenes.switchTo("AboutPageFXML");
        
    }
    
    @FXML
    private void goToDIY(ActionEvent event){
        SwitchScenes.switchTo("DIY");
        
    }
    
    @FXML
    private void goToMoneyManager(ActionEvent event){
        SwitchScenes.switchTo("MoneyManager");
        
    }
    
    @FXML
    private void exitApp(ActionEvent event){
        Platform.exit();
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
