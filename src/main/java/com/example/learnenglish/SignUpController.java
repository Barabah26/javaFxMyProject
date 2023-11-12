package com.example.learnenglish;

import com.example.learnenglish.db.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private Button logInButton;

    @FXML
    private Button signBack;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textPassword;

    private Stage dialogStage;

    @FXML
    void logIn(ActionEvent event) {
        try {
            logInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Log_in.fxml"));
            Parent root = loader.load();
            LogInController logInController = loader.getController();
            Stage logInDialogStage = new Stage();
            logInDialogStage.setTitle("Log in");
            logInDialogStage.initModality(Modality.WINDOW_MODAL);
            logInDialogStage.initOwner(logInButton.getScene().getWindow());
            Scene scene = new Scene(root);
            logInDialogStage.setScene(scene);

            logInController.setDialogStage(logInDialogStage);

            logInDialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void signUp(ActionEvent event) {
        String emailText = textEmail.getText().trim();
        String passwordText = textPassword.getText().trim();
        if (!emailText.equals("") && !passwordText.equals("")){
            signUpNewUser();
            try {
                signUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Log_in.fxml"));
                Parent root = loader.load();
                LogInController logInController = loader.getController();
                Stage logInDialogStage = new Stage();
                logInDialogStage.setTitle("Log in");
                logInDialogStage.initModality(Modality.WINDOW_MODAL);
                logInDialogStage.initOwner(signUpButton.getScene().getWindow());
                Scene scene = new Scene(root);
                logInDialogStage.setScene(scene);

                logInController.setDialogStage(logInDialogStage);

                logInDialogStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

    private void signUpNewUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String email = textEmail.getText();
        String password = textPassword.getText();
        User user = new User(email,password);
        databaseHandler.signUpUser(user);
    }

    @FXML
    void signUpBack(ActionEvent event) {
        try {
            signBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();
            MainController mainController = loader.getController();
            Stage mController = new Stage();
            mController.setTitle("Learn English with fun");
            mController.initModality(Modality.WINDOW_MODAL);
            mController.initOwner(signBack.getScene().getWindow());
            Scene scene = new Scene(root);
            mController.setScene(scene);

            mainController.setDialogStage(mController);

            mController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
