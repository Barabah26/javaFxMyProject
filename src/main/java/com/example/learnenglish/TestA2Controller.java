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

public class TestA2Controller {
    private Stage dialogStage;

    @FXML
    private Button a2TestBack;

    @FXML
    private Label countA2;

    @FXML
    private TableView<Word> tableTestA2;

    @FXML
    private TableColumn<Word, String> translate;

    @FXML
    private TableColumn<Word, String> wordsInEnglish;

    private int correctAnswersCount = 0;

    @FXML
    void initialize() {
        // Завантаження слів з бази даних
        loadWordsFromDatabase();

        tableTestA2.setEditable(true);

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
        List<Word> a2WordList = dbHandler.getA2EnglishWords();
        tableTestA2.setItems(FXCollections.observableArrayList(a2WordList));
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
        List<Word> a2WordList = dbHandler.getA2Words(); // Отримання списку всіх слів з бази даних

        // Нормалізація регістру
        final String normalizedWord = wordInEnglish.toLowerCase();

        // Шукаю введене слово у списку слів
        Optional<Word> matchingWord = a2WordList.stream()
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
        countA2.setText("Your grade is: " + correctAnswersCount + "/50");
    }


    @FXML
    void translateEditCommit(TableColumn.CellEditEvent<Word, String> event) {
        Word word = event.getRowValue();
        word.setTranslate(event.getNewValue());
        checkTranslation(word);

        // Оновлення TableView після зміни значення перекладу
        tableTestA2.refresh();
    }


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

            backController.setResizable(false);
            a2Controller.setDialogStage(backController);
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
