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

public class TestB2Controller {
    private Stage dialogStage;

    @FXML
    private Button b2TestBack;

    @FXML
    private Label countB2;

    @FXML
    private TableView<Word> tableTestB2;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;

    private int correctAnswersCount = 0;

    @FXML
    void initialize() {
        // Завантаження слів з бази даних
        loadWordsFromDatabase();

        tableTestB2.setEditable(true);

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
        List<Word> b2WordList = dbHandler.getB2EnglishWords();
        tableTestB2.setItems(FXCollections.observableArrayList(b2WordList));
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
        List<Word> b2WordList = dbHandler.getB2Words(); // Отримання списку всіх слів з бази даних

        // Нормалізація регістру
        final String normalizedWord = wordInEnglish.toLowerCase();

        // Шукаю введене слово у списку слів
        Optional<Word> matchingWord = b2WordList.stream()
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
        countB2.setText("Your grade is: " + correctAnswersCount + "/50");
    }


    @FXML
    void translateEditCommit(TableColumn.CellEditEvent<Word, String> event) {
        Word word = event.getRowValue();
        word.setTranslate(event.getNewValue());
        checkTranslation(word);

        // Оновлення TableView після зміни значення перекладу
        tableTestB2.refresh();
    }

    @FXML
    void b2TestBack(ActionEvent event) {
        try {
            b2TestBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("B2.fxml"));
            Parent root = loader.load();
            B2Controller b2Controller = loader.getController();
            Stage backController = new Stage();
            backController.setTitle("B2");
            backController.initModality(Modality.WINDOW_MODAL);
            backController.initOwner(b2TestBack.getScene().getWindow());
            Scene scene = new Scene(root);
            backController.setScene(scene);

            backController.setResizable(false);
            b2Controller.setDialogStage(backController);
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
