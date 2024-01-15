package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginFormController {

    @FXML
    private BorderPane pane;

    @FXML
    private JFXButton btnAdminUser;

    @FXML
    private JFXButton btnUser;

    @FXML
    void adminUserBtnOnAction(ActionEvent event) {

    }

    @FXML
    void userBtnOnAction(ActionEvent event) {

    }

    public void adminUserBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/OwnerDashBoardForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void userBtnOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/EmployeeDashBoardForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
