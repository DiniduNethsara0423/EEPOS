package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ItemsFormController {

    public TableColumn colItemId;
    public TableColumn colName;
    public TableColumn colCategory;
    public TableColumn colStatues;
    public TableColumn colOrderId;
    public TableColumn colDelete;
    public Label orderIdLbl;
    public JFXComboBox combostatus;
    @FXML
    private BorderPane pane;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    void logOutBtnOnAction(ActionEvent event) {

    }



    public void logOutBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/LoginForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void backBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/EmployeeDashBoardForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBtnOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void statusComboOnAction(javafx.event.ActionEvent actionEvent) {
    }
}
