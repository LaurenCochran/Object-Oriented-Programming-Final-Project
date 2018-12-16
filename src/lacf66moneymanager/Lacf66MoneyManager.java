
package lacf66moneymanager;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lacf66MoneyManager extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        HBox root = new HBox();
        root.setPrefSize(600, 450);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("This is a failure!");
        message.setFont(Font.font(STYLESHEET_MODENA, 32));
        root.getChildren().add(message);

        Scene scene = new Scene(root);
        
        SwitchScenes.scene = scene; 
        SwitchScenes.switchTo("loginFXML");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
