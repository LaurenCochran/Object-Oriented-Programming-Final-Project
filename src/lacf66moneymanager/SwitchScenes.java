
package lacf66moneymanager;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class SwitchScenes {
    
    public static Scene scene;
    public static final HashMap<String, SwitchScenes> controllers = new HashMap<>();
    
    private Parent root;
    
    public static SwitchScenes add(String name) {
        SwitchScenes controller; 
        
        controller = controllers.get(name); 
        
        if(controller == null){
            try {
                
                FXMLLoader loader = new FXMLLoader(SwitchScenes.class.getResource("/View/" + name + ".fxml"));
                 
                Parent root = loader.load();
                
                controller = loader.getController(); 
                
                controller.setRoot(root); 
                
                controllers.put(name, controller); 
                
            } catch (IOException ex) {
                Logger.getLogger(SwitchScenes.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            } catch (Exception ex){
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            }
        }
        return controller; 
    }
    
    public static void switchTo(String name) {
        SwitchScenes controller = controllers.get(name); 
        
        if(controller == null){
            controller = add(name); 
        }
        
        if(controller != null){
            if(scene != null){
                scene.setRoot(controller.getRoot());
            }
        }
    }
    
    public void setRoot(Parent root) {
        this.root = root;
    }
    
    public Parent getRoot() {
        return root;
    }
    
    public static SwitchScenes getControllerByName(String name) {
        return controllers.get(name);
    }
    
}
