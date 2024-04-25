package unit16;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class TextAreaDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Declare and create a description pane
        DescriptionPane descriptionPane = new DescriptionPane();

        // Set title, text and image in the description pane
        descriptionPane.setTitle("Canada");
        String description = "The National Flag of Canada (French: Drapeau national du Canada),[1] often simply referred " +
                "to as the Canadian flag or, unofficially, as the maple leaf flag or consists of a red field with a white " +
                "square at its centre in the ratio of 1∶2∶1, in which is featured a stylized, red, 11-pointed maple leaf" +
                " charged in the centre.[2] It is the first flag to have been adopted by both houses of Parliament and " +
                "officially proclaimed by the Canadian monarch as the country's official national flag.[3] The flag has" +
                " become the predominant and most recognizable national symbol of Canada.";
        ImageView imv = new ImageView(String.valueOf(getClass().getResource("/images/ca.gif")));
        imv.setPreserveRatio(true);
        imv.setFitWidth(200);
        descriptionPane.setImageView(imv);
        descriptionPane.setDescription(description);


        // Create a scene and place it in the stage
        Scene scene = new Scene(descriptionPane, 450, 300);
        primaryStage.setTitle("TextAreaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}