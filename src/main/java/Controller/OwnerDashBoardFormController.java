package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class OwnerDashBoardFormController {

    @FXML
    private BorderPane pane;

    @FXML
    private JFXButton btnEmployees;

    @FXML
    private JFXButton btnSalesReports;

    @FXML
    private JFXButton OrderReports;

    @FXML
    private JFXButton btnCustomerReports;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    void customerReportsBtnOnAction(ActionEvent event) {

    }

    @FXML
    void employeesBtnOnAction(ActionEvent event) {

    }

    @FXML
    void logOutBtnOnAction(ActionEvent event) {

    }

    @FXML
    void orderReportsBtnOnAction(ActionEvent event) {

    }

    @FXML
    void salesReportsBtnOnAction(ActionEvent event) {

    }

    public void employeesBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/EmployeeReportsForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void salesReportsBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/SalesReportsForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void orderReportsBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/OrderReportsForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void customerReportsBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/CoustomerReportsForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logOutBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage=(Stage)  pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/LoginForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
