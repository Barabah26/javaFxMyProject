package com.example.learnenglish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TestB2Controller {
    private Stage dialogStage;

    @FXML
    private Button b2TestBack;

    @FXML
    private Label countB2;

    @FXML
    private TableView<?> tableTestB2;

    @FXML
    private TableColumn<?, ?> translate;

    @FXML
    private TableColumn<?, ?> wordsInEnglish;

    @FXML
    void b2TestBack(ActionEvent event) {
        try {
            b2TestBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("B2.fxml"));
            Parent root = loader.load();
            B2Controller b2Controller = loader.getController();
            Stage backController = new Stage();
            backController.setTitle("B2");
            backController.initModality(Modality.WINDOW_MODAL);
            backController.initOwner(b2TestBack.getScene().getWindow());
            Scene scene = new Scene(root);
            backController.setScene(scene);

            b2Controller.setDialogStage(backController);

            backController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
