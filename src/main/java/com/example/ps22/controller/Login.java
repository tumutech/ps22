package com.example.ps22.controller;

import com.example.ps22.Main;
import com.example.ps22.model.sqliteModel;
import com.example.ps22.model.useraccount;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.EventObject;
import java.util.ResourceBundle;

public class Login implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button login;
    Connection c = null;
    Statement stmt = null;
    @FXML
    private TextField username;
    @FXML PasswordField mpassword;
    @FXML
    private Label loginmessage;
    private PasswordField myp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
//    public void dologin() throws IOException {
////        try {
////            Class.forName("org.sqlite.JDBC");
////            c = DriverManager.getConnection("jdbc:sqlite:test.db");
////            stmt = c.createStatement();
////            String sql = "CREATE TABLE USERS " +
////                    "(ID INT PRIMARY KEY     NOT NULL," +
////                    " USERNAME           TEXT    NOT NULL, " +
////                    " PHONE            INT     NOT NULL, " +
////                    " PASSWORD        CHAR(50), " +
////                    " SALARY         REAL)";
////            stmt.executeUpdate(sql);
////            stmt.close();
////            c.close();
////        } catch ( Exception e ) {
////            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
////            System.exit(0);
////        }
//        System.out.println(username.getText());
//       // System.out.println(myp.getText());
//        if (username.getText().equals("julius") && password.getText().equals("lubricants")){
//            Parent root = FXMLLoader.load(Main.class.getResource("controlpanel.fxml"));
//            Stage window = (Stage) login.getScene().getWindow();
//            window.setScene(new Scene(root));
//        }
//        else{
//            loginmessage.setText("Invalid credentials");
//        }
//        System.out.println("Opened database successfully");
//
//
//    }
public void dologin() throws Exception {
    System.out.println("clicked!");
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:users.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");

        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            //int age = rs.getInt("age");
            String password = rs.getString("Password");
            //float salary = rs.getFloat("salary");

            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("PASSWORD = " + password);
//                    System.out.println("ADDRESS = " + address);
//                    System.out.println("SALARY = " + salary);
//            System.out.println();
            if (username.getText().equals(name) && mpassword.getText().equals(password)){
            Parent root = FXMLLoader.load(Main.class.getResource("controlpanel.fxml"));
            Stage window = (Stage) login.getScene().getWindow();
            window.setScene(new Scene(root));
        }
        else{
            loginmessage.setText("Invalid credentials");
        }
        }
        rs.close();
        stmt.close();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    System.out.println("Operation done successfully");
}

//    String m = username.getText();
//    String p = password.getText();
//    try {
//        if (sqliteModel.loginValidateFunc(username.getText(),password.getText())) {
//            //errorlabel.setText("Login Success !");
//            Parent root = FXMLLoader.load(Main.class.getResource("controlpanel.fxml"));
//            Stage window = (Stage) login.getScene().getWindow();
//            window.setScene(new Scene(root));
//        }
//        else {
//            //errorlabel.setText("Wrong Email or Password !");
//        }}
//        catch (SQLException e) {
//           loginmessage.setText("Invalid credentials");
//        e.printStackTrace();
//
//    }
}

