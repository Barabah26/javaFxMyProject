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

public class TestB1Controller {
    private Stage dialogStage;

    @FXML
    private Button b1TestBack;

    @FXML
    private Label countB1;

    @FXML
    private TableView<?> tableTestB1;

    @FXML
    private TableColumn<?, ?> translate;

    @FXML
    private TableColumn<?, ?> wordsInEnglish;

    @FXML
    void b1TestBack(ActionEvent event) {
        try {
            b1TestBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("B1.fxml"));
            Parent root = loader.load();
            B1Controller b1Controller = loader.getController();
            Stage backController = new Stage();
            backController.setTitle("B1");
            backController.initModality(Modality.WINDOW_MODAL);
            backController.initOwner(b1TestBack.getScene().getWindow());
            Scene scene = new Scene(root);
            backController.setScene(scene);

            b1Controller.setDialogStage(backController);

            backController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
