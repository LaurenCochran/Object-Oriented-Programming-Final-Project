package Controllers;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lacf66moneymanager.SwitchScenes;
import lacf66moneymanager.*;

public class AboutPageController extends SwitchScenes implements Initializable {
    
    @FXML
    public Button goBack;
    
    @FXML
    private void goToHomePage(ActionEvent event){
        SwitchScenes.switchTo("HomePageFXML");
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
