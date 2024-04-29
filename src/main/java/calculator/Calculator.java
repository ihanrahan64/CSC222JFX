/**
 * CSIS 312 Assignment 2.
 * @author Wade Schofield and Abby Schofield
 *
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program.
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
 * !! No changes needed to this file !!
 **/

package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import shoppinglist.ShoppingList;

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
