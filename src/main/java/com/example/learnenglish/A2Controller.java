package com.example.learnenglish;

import com.example.learnenglish.db.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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

public class A2Controller {
    private Stage dialogStage;
    @FXML
    private Button a2BackButton;

    @FXML
    private Button a2TestButton;

    @FXML
    private TableView<Word> tableLevelA2;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;

    @FXML
    private void initialize() {
        // Ініціалізація колонок
        wordsInEnglish.setCellValueFactory(new PropertyValueFactory<>("wordsInEnglish"));
        translate.setCellValueFactory(new PropertyValueFactory<>("translate"));

        tableLevelA2.getItems().clear();

        // Завантаження даних з бази даних
        loadWordsFromDatabase();
    }

    private void loadWordsFromDatabase() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        List<Word> a2Words = databaseHandler.getA2Words();

        // Встановлення нових даних для таблиці
        tableLevelA2.setItems(FXCollections.observableArrayList(a2Words));
    }


    @FXML
    void a2Back(ActionEvent event) {
        try {
            a2BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Levels.fxml"));
            Parent root = loader.load();
            LevelsController levelsController = loader.getController();
            Stage levelController = new Stage();
            levelController.setTitle("Levels");
            levelController.initModality(Modality.WINDOW_MODAL);
            levelController.initOwner(a2BackButton.getScene().getWindow());
            Scene scene = new Scene(root);
            levelController.setScene(scene);

            levelsController.setDialogStage(levelController);

            levelController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void a2Test(ActionEvent event) {
        try {
            a2TestButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestA2.fxml"));
            Parent root = loader.load();
            TestA2Controller testA2Controller = loader.getController();
            Stage testController = new Stage();
            testController.setTitle("TestA2");
            testController.initModality(Modality.WINDOW_MODAL);
            testController.initOwner(a2TestButton.getScene().getWindow());
            Scene scene = new Scene(root);
            testController.setScene(scene);

            testA2Controller.setDialogStage(testController);

            testController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
