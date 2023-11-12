package com.example.learnenglish;

import com.example.learnenglish.db.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private Label errorLabel;

    @FXML
    private TextField enterEmail;

    @FXML
    private TextField enterPassword;

    @FXML
    private Button logButton;

    @FXML
    private Button logInBack;

    @FXML
    private Button signButton;

    private Stage dialogStage;

    @FXML
    void log() {
        String emailText = enterEmail.getText().trim();
        String passwordText = enterPassword.getText().trim();

        if (!emailText.isEmpty() && !passwordText.isEmpty()) {
            loginUser(emailText, passwordText);
        }
    }




    @FXML
    void logBack(ActionEvent event) {
        try {
            logInBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign_up.fxml"));
            Parent root = loader.load();
            SignUpController signUpController = loader.getController();
            Stage mController = new Stage();
            mController.setTitle("Sign Up");
            mController.initModality(Modality.WINDOW_MODAL);
            mController.initOwner(logInBack.getScene().getWindow());
            Scene scene = new Scene(root);
            mController.setScene(scene);

            signUpController.setDialogStage(mController);

            mController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void sign(ActionEvent event) {
        try {
            logInBack.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sign_up.fxml"));
            Parent root = loader.load();
            SignUpController signUpController = loader.getController();
            Stage mController = new Stage();
            mController.setTitle("Sign Up");
            mController.initModality(Modality.WINDOW_MODAL);
            mController.initOwner(signButton.getScene().getWindow());
            Scene scene = new Scene(root);
            mController.setScene(scene);

            signUpController.setDialogStage(mController);

            mController.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void loginUser(String emailText, String passwordText) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setEmail(emailText);
        user.setPassword(passwordText);

        if (databaseHandler.checkUser(user)) {
            // Установка успішності логіну в контролері LevelsController
            LevelsController.setLoginSuccessful(true);
            System.out.println("Login successful");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Levels.fxml"));
                Parent root = loader.load();
                LevelsController levelsController = loader.getController();
                Stage levelsDialogStage = new Stage();
                levelsDialogStage.setTitle("Levels");
                levelsDialogStage.initModality(Modality.WINDOW_MODAL);
                levelsDialogStage.initOwner(logButton.getScene().getWindow());
                Scene scene = new Scene(root);
                levelsDialogStage.setScene(scene);

                levelsController.setDialogStage(levelsDialogStage);

                levelsDialogStage.show();

//                logButton.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
//             Відображення повідомлення про невдачу
            errorLabel.setText("Невірний email або пароль");
            errorLabel.setVisible(true);
        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
