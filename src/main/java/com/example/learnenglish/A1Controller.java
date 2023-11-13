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

public class A1Controller {
    private Stage dialogStage;

    @FXML
    private Button a1BackButton;

    @FXML
    private Button a1TestButton;

    @FXML
    private TableView<?> tableLevelA1;

    @FXML
    private TableColumn<?, ?> translate;

    @FXML
    private TableColumn<?, ?> wordsInEnglish;

    @FXML
    void a1Back(ActionEvent event) {
        try {
            a1BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Levels.fxml"));
            Parent root = loader.load();
            LevelsController levelsController = loader.getController();
            Stage levelController = new Stage();
            levelController.setTitle("Levels");
            levelController.initModality(Modality.WINDOW_MODAL);
            levelController.initOwner(a1BackButton.getScene().getWindow());
            Scene scene = new Scene(root);
            levelController.setScene(scene);

            levelsController.setDialogStage(levelController);

            levelController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void a1Test(ActionEvent event) {
        try {
            a1TestButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestA1.fxml"));
            Parent root = loader.load();
            TestA1Controller testA1Controller = loader.getController();
            Stage testController = new Stage();
            testController.setTitle("TestA1");
            testController.initModality(Modality.WINDOW_MODAL);
            testController.initOwner(a1TestButton.getScene().getWindow());
            Scene scene = new Scene(root);
            testController.setScene(scene);

            testA1Controller.setDialogStage(testController);

            testController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
