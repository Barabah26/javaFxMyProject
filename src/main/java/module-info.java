module com.example.learnenglish {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jbcrypt;

    opens com.example.learnenglish to javafx.fxml;
    exports com.example.learnenglish;
    exports com.example.learnenglish.db;
    opens com.example.learnenglish.db to javafx.fxml;
}