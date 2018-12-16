/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lacf66moneymanager.MoneyManagerFunctionality;
import lacf66moneymanager.SwitchScenes;

/**
 * FXML Controller class
 *
 * @author Owner1
 */
public class DIYController extends SwitchScenes implements Initializable, MoneyManagerFunctionality {
    @FXML
    public AnchorPane root;
    
    @FXML
    public TextArea fileArea;
    
    @FXML
    @Override
    public void handleOpen(ActionEvent event){
        FileChooser fileChooser = new FileChooser(); 
        
        Stage stage = (Stage) root.getScene().getWindow(); 
        
        
        
        File file = fileChooser.showOpenDialog(stage);
        
        if(file != null){
            
            BufferedReader bufferedReader = null; 
            
            String document = ""; 
            String line = ""; 
            
            try {
                bufferedReader = new BufferedReader( new FileReader(file));
                
                 while((line = bufferedReader.readLine()) != null){
                     document += line + "\n";
                } 
                 
                 fileArea.setText(document);
                 
            } catch (FileNotFoundException ex) {
                displayExceptionAlert(ex);
            } catch (IOException ex) {
                displayExceptionAlert(ex);
            }finally{
                if(bufferedReader != null){
                    
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        displayExceptionAlert(ex);
                    }
                }
            }
            
           
            
   
        }
    }
    
    @FXML
    @Override
    public void handleSave(ActionEvent event){
        FileChooser fileChooser = new FileChooser(); 
        Stage stage = (Stage) root.getScene().getWindow(); 
        
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        
        File file = fileChooser.showSaveDialog(stage); 
        
        FileWriter writer = null; 
        
        if(file != null){
            try {
                writer = new FileWriter(file);
                
                writer.write(fileArea.getText());
                
            } catch (IOException ex) {
                displayExceptionAlert(ex);
            } catch (Exception ex){
                displayExceptionAlert(ex);
            } finally {
                if(writer != null){
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        displayExceptionAlert(ex);
                    }
                }
            }
            
            
        }
    }
    
    @FXML
    public void handleGoBack(ActionEvent event){
        SwitchScenes.switchTo("HomePageFXML");
    }
    
    private void displayExceptionAlert(Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(ex.getMessage());
        
        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait(); 
    }
    
    @FXML
    @Override
    public void handleClear(ActionEvent event){
        fileArea.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
