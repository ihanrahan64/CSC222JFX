module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires jakarta.activation;

    opens com.jfx.c222jfx to javafx.fxml;
    opens shoppinglist to javafx.fxml, jakarta.xml.bind;
    exports com.jfx.c222jfx;
    exports shoppinglist;
    exports myjavafx;
    exports multiplestagedemo;
    exports buttoninpane;
    exports showcircle;
    exports showcirclecentered;
    exports bindingdemo;
    exports nodestylerotatedemo;
    exports clock;
    exports unit15.loancalculator;
    exports unit15.eventhandler;
    exports unit15.controlcircle;

}