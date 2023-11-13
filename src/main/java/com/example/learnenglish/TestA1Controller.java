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

public class TestA1Controller {
    private Stage dialogStage;

    @FXML
    private Button a1TestBack;

    @FXML
    private Label countA1;

    @FXML
    private TableView<?> tableTestA1;

    @FXML
    private TableColumn<?, ?> translate;

    @FXML
    private TableColumn<?, ?> wordsInEnglish;

    @FXML
    void a1TestBack(ActionEvent event) {
        try {
            a1TestBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("A1.fxml"));
            Parent root = loader.load();
            A1Controller a1Controller = loader.getController();
            Stage backController = new Stage();
            backController.setTitle("A1");
            backController.initModality(Modality.WINDOW_MODAL);
            backController.initOwner(a1TestBack.getScene().getWindow());
            Scene scene = new Scene(root);
            backController.setScene(scene);

            a1Controller.setDialogStage(backController);

            backController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
