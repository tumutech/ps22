module com.example.ps22 {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;
    requires java.desktop;
    requires java.sql;
    requires sqlite.jdbc;


    opens com.example.ps22 to javafx.fxml;
    exports com.example.ps22;
    exports com.example.ps22.model;
    opens com.example.ps22.model to javafx.fxml;
    exports com.example.ps22.controller;
    opens com.example.ps22.controller to javafx.fxml;
}