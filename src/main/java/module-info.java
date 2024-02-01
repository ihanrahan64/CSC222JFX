module com.jfx.c222jfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jfx.c222jfx to javafx.fxml;
    exports com.jfx.c222jfx;
}