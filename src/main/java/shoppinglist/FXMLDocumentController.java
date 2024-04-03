/*
 * Controller for Shopping List Example (ws)
 */
package shoppinglist;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Wade
 */
public class FXMLDocumentController implements Initializable {
    ShoppingListModel myList;
    @FXML
    private TableView<Item> shoppingTable;
    @FXML
    private TableColumn<Item, String> itemColumn;
    @FXML
    private TableColumn<Item, Integer> qtyColumn;
    @FXML
    private TableColumn<Item, Float> priceColumn;
    @FXML
    private TableColumn<Item, String> notesColumn;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonUpdate;
    @FXML
    private TextField itemField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField notesField;
    @FXML
    private Button buttonFind;
    @FXML
    private Button buttonClear;
    @FXML
    private TextField totalItems;
    @FXML
    private TextField totalCost;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField txtAvgCost;

    /**
     * Add or modify shopping list item when update button is pressed
     * @param event 
     */
    @FXML
    void handleButtonUpdate(ActionEvent event) {
        try {
            Item i = new Item(itemField.getText(), Integer.parseInt(quantityField.getText()),
                    Float.parseFloat(priceField.getText()), notesField.getText());
            myList.addItem(i);
            updateDisplay();
            clearFields();
            itemField.requestFocus();
            updateDisplay();
        }
        catch (NumberFormatException ex) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Correct Item Fields");
            System.out.println(a.contentTextProperty());
            a.setTitle("Input Error");
            a.show();
        }
    }

    /**
     * Removes shopping list items with matching description
     * @param event 
     */
    @FXML
    void handleButtonDelete(ActionEvent event) {
        Item i = new Item(itemField.getText(), 0, 0, notesField.getText());
        myList.removeItem(i);
        updateDisplay();
        clearFields();
    }

    /**
     * Finds shopping list items based on the description
     * @param event 
     */
    @FXML
    void handleButtonFind(ActionEvent event) {
        Item i = new Item(itemField.getText(), 0, 0, notesField.getText());
        List<Item> l = myList.findItem(i);
        shoppingTable.getItems().setAll(l);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myList = new ShoppingListModel();
        myList.loadList();
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        qtyColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        updateDisplay();
    }

    /**
     * Clears the text fields and updates the display
     * @param event 
     */
    @FXML
    void handleButtonClear(ActionEvent event) {
        clearFields();
        updateDisplay();
    }

    /**
     * Populates the text fields when a row in the table is clicked
     * @param event 
     */
    @FXML
    void handleTableClick(MouseEvent event) {
        Item i = shoppingTable.getSelectionModel().getSelectedItem();
        if (i != null) {
            itemField.setText(i.getItem());
            quantityField.setText(String.valueOf(i.getQuantity()));
            priceField.setText(String.valueOf(i.getPrice()));
            notesField.setText(String.valueOf(i.getNotes()));
        }
    }

    /**
     * Intercepts the ENTER key and adds/updates a record if applicable
     * @param event 
     */
    @FXML
    void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (itemField.getText().length() > 0) {
                Item i = new Item(itemField.getText(), Integer.parseInt(quantityField.getText()),
                        Float.parseFloat(priceField.getText()), notesField.getText());
                myList.addItem(i);
                updateDisplay();
                clearFields();
                itemField.requestFocus();
            }
        }
    }

    /**
     * Updates the display including the total item count and cost
     */
    private void updateDisplay() {
        float cost = 0;
        int itemCount = 0;
        shoppingTable.getItems().setAll(myList.getItems());
        List<Item> items = myList.getItems();
        for (Item item : items) {
            cost += item.getCost();
            itemCount += item.getQuantity();
        }
        totalItems.setText(String.valueOf(itemCount));
        totalCost.setText(String.format("%.2f",cost));
        txtAvgCost.setText(String.format("%.2f",cost/itemCount));
    }

    /**
     * Clears the text fields
     */
    private void clearFields() {
        itemField.setText("");
        quantityField.setText((""));
        priceField.setText((""));
        notesField.setText("");
    }
}
