package com.example.learnenglish;

import com.example.learnenglish.db.DatabaseHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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

public class TestA1Controller {
    private Stage dialogStage;

    @FXML
    private Button a1TestBack;

    @FXML
    private Label countA1;

    @FXML
    private TableView<Word> tableTestA1;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;

    private int correctAnswersCount = 0;


    @FXML
    void initialize() {
        // Завантаження слів з бази даних
        loadWordsFromDatabase();

        tableTestA1.setEditable(true);

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
        List<Word> a1WordList = dbHandler.getA1EnglishWords();
        tableTestA1.setItems(FXCollections.observableArrayList(a1WordList));
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
        List<Word> a1WordList = dbHandler.getA1Words(); // Отримання списку всіх слів з бази даних

        // Нормалізація регістру
        final String normalizedWord = wordInEnglish.toLowerCase();

        // Шукаю введене слово у списку слів
        Optional<Word> matchingWord = a1WordList.stream()
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
        countA1.setText("Your grade is: " + correctAnswersCount);
    }


    @FXML
    void translateEditCommit(TableColumn.CellEditEvent<Word, String> event) {
        Word word = event.getRowValue();
        word.setTranslate(event.getNewValue());
        checkTranslation(word);

        // Оновлення TableView після зміни значення перекладу
        tableTestA1.refresh();
    }




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
