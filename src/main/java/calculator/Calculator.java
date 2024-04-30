/**
 * !! No changes needed to this file !!
 **/

package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author 
 */

public class Calculator extends Application
{    
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(Calculator.class.getResource("/calculator/CalculatorView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("RPN-CALC");
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(Calculator.class.getResource("/calculator/CVCC_Initials_B.png"))));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
