
package Model;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SceneModel {
    
    
    
    public double total = 0.0;
    
    TextField moneyAmount;
    TextField aboutInfo;
    
    public SceneModel(TextField moneyAmount, TextField aboutInfo){
        moneyAmount = this.moneyAmount;
        aboutInfo = this.aboutInfo;
    }
    
    public String getText(TextField text){
        return text.getText();
    }
    
       
    public double convertStringToDouble(String text){
        double moneyAmount = Double.parseDouble(text);
        return moneyAmount;
    }
    
}
