package com.example.ps22.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqliteModel {
    static Connection connection;

    public sqliteModel() throws SQLException, ClassNotFoundException {
        connection = sqliteConnection.Connector();
        if (connection == null) System.exit(1);
    }

    public boolean isDbConnected() throws SQLException {
        return !connection.isClosed();
    }

    public static boolean loginValidateFunc(String userName, String password) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "select * from USERS where Name = ? and Password = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}