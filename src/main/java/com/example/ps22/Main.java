package com.example.ps22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        checkDrivers();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 800, 1200);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Real Auditor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:/C:/Users/TUMTECH/Desktop/ps22/src/main/resources/com/example/ps22/images/rg.png"));
        stage.show();
    }
    private static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            System.out.println("Drivers working");
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
            return false;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}