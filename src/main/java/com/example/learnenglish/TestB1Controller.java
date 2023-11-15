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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TestB1Controller {
    private Stage dialogStage;

    @FXML
    private Button b1TestBack;

    @FXML
    private Label countB1;

    @FXML
    private TableView<Word> tableTestB1;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;
    private int correctAnswersCount = 0;

    @FXML
    void initialize() {
        // Завантаження слів з бази даних
        loadWordsFromDatabase();

        tableTestB1.setEditable(true);

        translate.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));

        wordsInEnglish.setCellValueFactory(new PropertyValueFactory<>("wordsInEnglish"));
        translate.setCellValueFactory(new PropertyValueFactory<>("translate"));
        translate.setCellFactory(TextFieldTableCell.forTableColumn());
        translate.setOnEditCommit(event -> {
            int editIndex = event.getTablePosition().getRow();
            Word editedWord = event.getTableView().getItems().get(editIndex);
            editedWord.setTranslate(event.getNewValue());
            checkTranslation(editedWord);
        });

    }


    private void loadWordsFromDatabase() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        List<Word> b1WordList = dbHandler.getB1EnglishWords();
        tableTestB1.setItems(FXCollections.observableArrayList(b1WordList));
    }

    private void checkTranslation(Word word) {
        String correctTranslation = getCorrectTranslation(word.getWordsInEnglish());

        if (word.getTranslate().equalsIgnoreCase(correctTranslation)) {
            correctAnswersCount++;

        }

        updateGradeLabel();
    }

    private String getCorrectTranslation(String wordInEnglish) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        List<Word> b1WordList = dbHandler.getB1Words(); // Отримання списку всіх слів з бази даних

        // Нормалізація регістру
        final String normalizedWord = wordInEnglish.toLowerCase();

        // Шукаю введене слово у списку слів
        Optional<Word> matchingWord = b1WordList.stream()
                .filter(word -> word.getWordsInEnglish().equalsIgnoreCase(normalizedWord))
                .findFirst();

        if (matchingWord.isPresent()) {
            Word word = matchingWord.get();
            return word.getTranslate(); // Повертаю коректний переклад
        } else {
            return "IncorrectTranslation";
        }
    }



    private void updateGradeLabel() {
        countB1.setText("Your grade is: " + correctAnswersCount + "/50");
    }


    @FXML
    void translateEditCommit(TableColumn.CellEditEvent<Word, String> event) {
        Word word = event.getRowValue();
        word.setTranslate(event.getNewValue());
        checkTranslation(word);

        // Оновлення TableView після зміни значення перекладу
        tableTestB1.refresh();
    }

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

            backController.setResizable(false);
            b1Controller.setDialogStage(backController);
            backController.setOnCloseRequest(Event::consume);

            backController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
