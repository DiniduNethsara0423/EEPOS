package edu.icet.crm.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.icet.crm.bo.BoFactory;
import edu.icet.crm.bo.BoType;
import edu.icet.crm.bo.custom.PlaceOrderBo;
import edu.icet.crm.dto.OrderDetailsDto;
import edu.icet.crm.dto.PlaceOrderDto;
import edu.icet.crm.dto.tm.PlaceOrderTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderViewController {

    public JFXTextField txtCustomerName;
    public JFXTextField txtContactNumber;
    public JFXTextField txtEmail;
    public JFXTextField txtItemName;
    public Label lblOrderId;
    public TableView<PlaceOrderTm> table;
    public TableColumn colItemNo;
    public TableColumn colCategory;
    public TableColumn colOption;
    public TableColumn colItemName;
    public JFXTextArea txtNote;
    @FXML
    private BorderPane pane;

    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXRadioButton electronicToggleBtn;
    @FXML
    private ToggleGroup category;
    @FXML
    private JFXRadioButton electricalToggleBtn;
    PlaceOrderBo placeOrderBo= BoFactory.getInstance().getBo(BoType.PLACE_ORDER_BO);
    ObservableList<PlaceOrderTm> tmList = FXCollections.observableArrayList();
    public void initialize() {
        // Set up cell value factories for table columns
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("button"));

        // Enable editing for the 'item name' column
        colItemName.setCellFactory(TextFieldTableCell.forTableColumn());

        lblOrderId.setText(setOrderId());
    }

    public String setOrderId(){
        return placeOrderBo.getLastOrderId();
    }

    @FXML
    void backBtnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/EmployeeView.fxml"))));
    }
    @FXML
    void logOutBtnOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"))));
    }
    //    private void handleCategorySelection() {
//
//        RadioButton selectedRadioButton = (RadioButton) category.getSelectedToggle();
//        if (selectedRadioButton != null) {
//            String selectedCategory = selectedRadioButton.getText();
//            System.out.println(electricalToggleBtn.isSelected());
//            System.out.println("Selected Category: " + selectedCategory);
//        }
//    }
    @FXML
    private void saveBtnOnAction() {
//        handleCategorySelection();
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
            tmList.add(placeOrderTm);
            table.setItems(tmList  );
            // Clear the input fields
            clearBtnOnAction();
        }
    }
    private JFXButton createDeleteButton() {
        JFXButton deleteButton = new JFXButton("Delete");
        deleteButton.setOnAction(event -> {
            PlaceOrderTm selectedItem = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(selectedItem);
        });
        return deleteButton;
    }
    private boolean isEmptyField(JFXTextField textField) {
        System.out.println(textField.getText());
        return textField.getText().trim().isEmpty();
    }

    public String getCurrentDateAsString() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the date as a string (you can customize the format)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }
    public void placeOrderBtnOnAction(ActionEvent actionEvent) {
        List<OrderDetailsDto> orderDetailsDtoList=new ArrayList<>();

        int lastItemId= placeOrderBo.getLstItemId();

        for (PlaceOrderTm placeOrderTm:tmList){
            orderDetailsDtoList.add(new OrderDetailsDto(
                    String.format("itm%d", ++lastItemId),
                    placeOrderTm.getItemName(),
                    placeOrderTm.getCategory()
            ));
        }

        PlaceOrderDto placeOrderDto=new PlaceOrderDto(
                placeOrderBo.getLastCustomerId(),
                txtCustomerName.getText(),
                txtEmail.getText(),
                txtContactNumber.getText(),
                lblOrderId.getText(),
                getCurrentDateAsString(),
                txtNote.getText(),
                orderDetailsDtoList
        );

        placeOrderBo.save(placeOrderDto);
    }



    public void clearBtnOnAction() {

        txtItemName.clear();
        category.selectToggle(null);
    }
    public void clearAllBtnOnAction(ActionEvent actionEvent) {
        txtCustomerName.clear();
        txtContactNumber.clear();
        txtEmail.clear();
        txtItemName.clear();
        category.selectToggle(null);
    }
}