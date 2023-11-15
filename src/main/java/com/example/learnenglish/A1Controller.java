package com.example.learnenglish;

import com.example.learnenglish.db.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class A1Controller {
    private Stage dialogStage;

    @FXML
    private Button a1BackButton;

    @FXML
    private Button a1TestButton;

    @FXML
    private TableView<Word> tableLevelA1;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;

    @FXML
    private void initialize() {
        // Ініціалізація колонок
        wordsInEnglish.setCellValueFactory(new PropertyValueFactory<>("wordsInEnglish"));
        translate.setCellValueFactory(new PropertyValueFactory<>("translate"));

        tableLevelA1.getItems().clear();

        // Завантаження даних з бази даних
        loadWordsFromDatabase();
    }

    private void loadWordsFromDatabase() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        List<Word> a1Words = databaseHandler.getA1Words();

        // Встановлення нових даних для таблиці
        tableLevelA1.setItems(FXCollections.observableArrayList(a1Words));
    }

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

            levelController.setResizable(false);

            levelsController.setDialogStage(levelController);

            levelController.setOnCloseRequest(Event::consume);

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

            testController.setResizable(false);

            testController.setOnCloseRequest(Event::consume);

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
