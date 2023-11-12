package com.example.learnenglish;

import javafx.stage.Stage;

public class LevelsController {
    private Stage dialogStage;

    private static boolean loginSuccessful = false;

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

