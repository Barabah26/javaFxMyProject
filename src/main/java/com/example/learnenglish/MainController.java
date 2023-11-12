package com.example.learnenglish;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button getStarted1;

    @FXML
    private Button getStarted2;

    @FXML
    private Button mainExit;

    private Stage dialogStage;

//    @FXML
//    void initialize(){
//        getStarted1.setOnAction(event -> {
//            getStarted1.getScene().getWindow().hide();
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("Sign_up.fxml"));
//
//            try {
//                fxmlLoader.load();
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            Parent root = fxmlLoader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//        });
//
//        getStarted2.setOnAction(event -> {
//            getStarted2.getScene().getWindow().hide();
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("Sign_up.fxml"));
//
//            try {
//                fxmlLoader.load();
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            Parent root = fxmlLoader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//        });
//    }


    @FXML
    private void getStarted(ActionEvent event) {
        getStarted1.getScene().getWindow().hide();
        getStarted2.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign_up.fxml"));
            Parent root = loader.load();
            SignUpController signUpController = loader.getController();
            Stage signUpDialogStage = new Stage();
            signUpDialogStage.setTitle("Sign up");
            signUpDialogStage.initModality(Modality.WINDOW_MODAL);
            signUpDialogStage.initOwner(getStarted1.getScene().getWindow());
            signUpDialogStage.initOwner(getStarted2.getScene().getWindow());
            Scene scene = new Scene(root);
            signUpDialogStage.setScene(scene);

            signUpController.setDialogStage(signUpDialogStage);

            signUpDialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    private void mainExit(ActionEvent event) {
        Stage stage = (Stage) mainExit.getScene().getWindow();
        stage.close();
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }



}