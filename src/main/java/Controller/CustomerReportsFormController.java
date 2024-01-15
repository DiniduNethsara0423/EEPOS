package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class CustomerReportsFormController {

    public BorderPane pane;
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    void backBtnOnAction(ActionEvent event) {

    }

    @FXML
    void logOutBtnOnAction(ActionEvent event) {

    }

    public void backBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/OwnerDashBoardForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logOutBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/LoginForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
