package com.example.learnenglish;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelsController {
    private Stage dialogStage;

    private static boolean loginSuccessful = false;

    @FXML
    private Button a1Button;

    @FXML
    private Button a2Button;

    @FXML
    private Button b1Button;

    @FXML
    private Button b2Button;

    @FXML
    private Button levelsBack;

    @FXML
    void a1(ActionEvent event) {
        try {
            a1Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("A1.fxml"));
            Parent root = loader.load();
            A1Controller a1Controller = loader.getController();
            Stage a1 = new Stage();
            a1.setTitle("A1");
            a1.initModality(Modality.WINDOW_MODAL);
            a1.initOwner(levelsBack.getScene().getWindow());
            Scene scene = new Scene(root);
            a1.setScene(scene);

            a1.setResizable(false);

            a1Controller.setDialogStage(a1);
            a1.setOnCloseRequest(Event::consume);

            a1.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void a2(ActionEvent event) {
        try {
            a2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("A2.fxml"));
            Parent root = loader.load();
            A2Controller a2Controller = loader.getController();
            Stage a2 = new Stage();
            a2.setTitle("A2");
            a2.initModality(Modality.WINDOW_MODAL);
            a2.initOwner(levelsBack.getScene().getWindow());
            Scene scene = new Scene(root);
            a2.setScene(scene);

            a2.setResizable(false);

            a2Controller.setDialogStage(a2);

            a2.setOnCloseRequest(Event::consume);

            a2.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void b1(ActionEvent event) {
        try {
            b1Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("B1.fxml"));
            Parent root = loader.load();
            B1Controller b1Controller = loader.getController();
            Stage b1 = new Stage();
            b1.setTitle("B1");
            b1.initModality(Modality.WINDOW_MODAL);
            b1.initOwner(levelsBack.getScene().getWindow());
            Scene scene = new Scene(root);
            b1.setScene(scene);

            b1.setResizable(false);

            b1Controller.setDialogStage(b1);
            b1.setOnCloseRequest(Event::consume);

            b1.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void b2(ActionEvent event) {
        try {
            b2Button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("B2.fxml"));
            Parent root = loader.load();
            B2Controller b2Controller = loader.getController();
            Stage b2 = new Stage();
            b2.setTitle("B2");
            b2.initModality(Modality.WINDOW_MODAL);
            b2.initOwner(levelsBack.getScene().getWindow());
            Scene scene = new Scene(root);
            b2.setScene(scene);

            b2.setResizable(false);
            b2.setOnCloseRequest(Event::consume);

            b2Controller.setDialogStage(b2);

            b2.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void levelBack(ActionEvent event) {
        try {
            levelsBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Log_in.fxml"));
            Parent root = loader.load();
            LogInController logInController = loader.getController();
            Stage logController = new Stage();
            logController.setTitle("Log in");
            logController.initModality(Modality.WINDOW_MODAL);
            logController.initOwner(levelsBack.getScene().getWindow());
            Scene scene = new Scene(root);
            logController.setScene(scene);
            logController.setResizable(false);

            logController.setResizable(false);
            logInController.setDialogStage(logController);
            logController.setOnCloseRequest(Event::consume);

            logController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setLoginSuccessful(boolean success) {
        loginSuccessful = success;
    }

    public static boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


}

