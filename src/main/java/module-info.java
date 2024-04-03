module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires jakarta.activation;

    opens com.jfx.c222jfx to javafx.fxml;
    opens shoppinglist to javafx.fxml, jakarta.xml.bind;
    exports com.jfx.c222jfx;
    exports shoppinglist;

}