package com.example.learnenglish;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class B2Controller {
    private Stage dialogStage;

    @FXML
    private Button b2BackButton;

    @FXML
    private Button b2TestButton;

    @FXML
    private TableView<?> tableLevelB2;

    @FXML
    private TableColumn<?, ?> translate;

    @FXML
    private TableColumn<?, ?> wordsInEnglish;

    @FXML
    void b2Back(ActionEvent event) {
        try {
            b2BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Levels.fxml"));
            Parent root = loader.load();
            LevelsController levelsController = loader.getController();
            Stage levelController = new Stage();
            levelController.setTitle("Levels");
            levelController.initModality(Modality.WINDOW_MODAL);
            levelController.initOwner(b2BackButton.getScene().getWindow());
            Scene scene = new Scene(root);
            levelController.setScene(scene);

            levelsController.setDialogStage(levelController);

            levelController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void b2Test(ActionEvent event) {
        try {
            b2TestButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestB2.fxml"));
            Parent root = loader.load();
            TestB2Controller testB2Controller = loader.getController();
            Stage testController = new Stage();
            testController.setTitle("TestB2");
            testController.initModality(Modality.WINDOW_MODAL);
            testController.initOwner(b2TestButton.getScene().getWindow());
            Scene scene = new Scene(root);
            testController.setScene(scene);

            testB2Controller.setDialogStage(testController);

            testController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
