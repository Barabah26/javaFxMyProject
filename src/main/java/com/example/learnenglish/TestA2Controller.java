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

public class TestA2Controller {
    private Stage dialogStage;

    @FXML
    private Button a2TestBack;

    @FXML
    private Label countA2;

    @FXML
    private TableView<?> tableTestA2;

    @FXML
    private TableColumn<?, ?> translate;

    @FXML
    private TableColumn<?, ?> wordsInEnglish;

    @FXML
    void a2TestBack(ActionEvent event) {
        try {
            a2TestBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("A2.fxml"));
            Parent root = loader.load();
            A2Controller a2Controller = loader.getController();
            Stage backController = new Stage();
            backController.setTitle("A2");
            backController.initModality(Modality.WINDOW_MODAL);
            backController.initOwner(a2TestBack.getScene().getWindow());
            Scene scene = new Scene(root);
            backController.setScene(scene);

            a2Controller.setDialogStage(backController);

            backController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
