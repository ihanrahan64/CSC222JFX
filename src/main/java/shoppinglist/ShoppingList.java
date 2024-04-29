/*
 * Shopping List Application
 */
package shoppinglist;

import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Wade
 */
public class ShoppingList extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(ShoppingList.class.getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);   
        stage.setTitle("Shopping List");    // sets title 
        stage.setScene(scene);
        stage.setResizable(false);          // disallow window resize
        stage.getIcons().add(new Image(String.valueOf(ShoppingList.class.getResource("CVCC_Initials_B.png"))));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}
