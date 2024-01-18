import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.tm.PlaceOrderTm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

 public class PlaceOrderFormController {
    public JFXTextField txtContactNumber;
    public JFXTextField txtEmail;
    public JFXTextField txtItemName;
    public Label lblOrderId;
    public TableView<PlaceOrderTm> table;
    public TableColumn colItemNo;
    public TableColumn colCategory;
    public TableColumn colOption;
    @FXML
    private BorderPane pane;

  public class PlaceOrderViewController {
        @FXML
        private JFXRadioButton electricalToggleBtn;

        public void initialize() {
            // Set up cell value factories for table columns
            colItemNo.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colOption.setCellValueFactory(new PropertyValueFactory<>("button"));

            // Enable editing for the 'item name' column
            colItemNo.setCellFactory(TextFieldTableCell.forTableColumn());
        }

        @FXML
        void backBtnOnAction(ActionEvent event) throws IOException {
           private void handleCategorySelection() {
                RadioButton selectedRadioButton = (RadioButton) category.getSelectedToggle();
                if (selectedRadioButton != null) {
                    String selectedCategory = selectedRadioButton.getText();
                    System.out.println(electricalToggleBtn.isSelected());
                    System.out.println("Selected Category: " + selectedCategory);
                }
            }

            @FXML
            private void addBtnOnAction() {
                handleCategorySelection();

                if (isEmptyField(txtCustomerName) || isEmptyField(txtContactNumber) || isEmptyField(txtEmail)
                        || isEmptyField(txtItemName) || !(electronicToggleBtn.isSelected() || electricalToggleBtn.isSelected()) ) {

                    new Alert(Alert.AlertType.WARNING,"Please fill in all required fields and select a category.").show();
                } else {
                    // Proceed with the "Add" functionality

                    // Get the selected category
                    RadioButton selectedRadioButton = (RadioButton) category.getSelectedToggle();
                    String selectedCategory = selectedRadioButton.getText();
                    System.out.println(selectedCategory);

                    // Create a PlaceOrderTm object
                    PlaceOrderTm placeOrderTm = new PlaceOrderTm(txtItemName.getText(), selectedCategory, createDeleteButton());

                    // Add the PlaceOrderTm to the table
                    table.getItems().add(placeOrderTm);

                    // Clear the input fields
                    clearBtnOnAction();
                }
            }

            private JFXButton createDeleteButton() {
                JFXButton deleteButton = new JFXButton("Delete");
                deleteButton.setOnAction(event -> {
                    // Handle the delete button action (you can remove the corresponding row from the table)
                    PlaceOrderTm selectedItem = table.getSelectionModel().getSelectedItem();
                    table.getItems().remove(selectedItem);
                });
                return deleteButton;
            }

            private boolean isEmptyField(JFXTextField textField) {
                System.out.println(textField.getText());
                return textField.getText().trim().isEmpty();
            }

            public void placeOrderBtnOnAction(ActionEvent actionEvent) {

            }

            public void clearBtnOnAction() {

                txtCustomerName.clear();
                txtContactNumber.clear();
                txtEmail.clear();
                txtItemName.clear();
                category.selectToggle(null);

            }
        }