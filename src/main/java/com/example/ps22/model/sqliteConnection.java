package com.example.ps22.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteConnection {
    public static Connection Connector() throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
        return conn;
    }

}