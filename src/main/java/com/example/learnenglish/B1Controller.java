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

public class B1Controller {
    private Stage dialogStage;

    @FXML
    private Button b1BackButton;

    @FXML
    private Button b1TestButton;

    @FXML
    private TableView<Word> tableLevelB1;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;

    @FXML
    private void initialize() {
        // Ініціалізація колонок
        wordsInEnglish.setCellValueFactory(new PropertyValueFactory<>("wordsInEnglish"));
        translate.setCellValueFactory(new PropertyValueFactory<>("translate"));

        tableLevelB1.getItems().clear();

        // Завантаження даних з бази даних
        loadWordsFromDatabase();
    }

    private void loadWordsFromDatabase() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        List<Word> b1Words = databaseHandler.getB1Words();

        // Встановлення нових даних для таблиці
        tableLevelB1.setItems(FXCollections.observableArrayList(b1Words));
    }


    @FXML
    void b1Back(ActionEvent event) {
        try {
            b1BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Levels.fxml"));
            Parent root = loader.load();
            LevelsController levelsController = loader.getController();
            Stage levelController = new Stage();
            levelController.setTitle("Levels");
            levelController.initModality(Modality.WINDOW_MODAL);
            levelController.initOwner(b1BackButton.getScene().getWindow());
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
    void b1Test(ActionEvent event) {
        try {
            b1TestButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestB1.fxml"));
            Parent root = loader.load();
            TestB1Controller testB1Controller = loader.getController();
            Stage testController = new Stage();
            testController.setTitle("TestB1");
            testController.initModality(Modality.WINDOW_MODAL);
            testController.initOwner(b1TestButton.getScene().getWindow());
            Scene scene = new Scene(root);
            testController.setScene(scene);

            testController.setResizable(false);

            testB1Controller.setDialogStage(testController);

            testController.setOnCloseRequest(Event::consume);

            testController.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
