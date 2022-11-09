package com.example.ps22.controller;
import java.sql.*;

public class createdatabase {

        public static void main( String args[] ) {
            Connection c = null;
            Statement stmt = null;

//            try {
//                Class.forName("org.sqlite.JDBC");
//                c = DriverManager.getConnection("jdbc:sqlite:users.db");
//                System.out.println("Opened database successfully");
//
//                stmt = c.createStatement();
//                String sql = "CREATE TABLE USERS " +
//                        "(ID INT PRIMARY KEY     NOT NULL," +
//                        " Name           TEXT    NOT NULL, " +
//                        " Password            TEXT     NOT NULL)";
//                stmt.executeUpdate(sql);
//                stmt.close();
//                c.close();
//            } catch ( Exception e ) {
//                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//                System.exit(0);
//            }
//            System.out.println("Table created successfully");
//        }
//            try {
//                Class.forName("org.sqlite.JDBC");
//                c = DriverManager.getConnection("jdbc:sqlite:users.db");
//                c.setAutoCommit(false);
//                System.out.println("Opened database successfully");
//
//                stmt = c.createStatement();
//                String sql = "INSERT INTO USERS (ID,Name,Password) " +
//                        "VALUES (1, 'julius','lubricants' );";
//                stmt.executeUpdate(sql);

//                sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//                        "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
//                stmt.executeUpdate(sql);
//
//                sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//                        "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
//                stmt.executeUpdate(sql);
//
//                sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//                        "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
//                stmt.executeUpdate(sql);
//
//                stmt.close();
//                c.commit();
//                c.close();
//            } catch ( Exception e ) {
//                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//                System.exit(0);
//            }
//            System.out.println("Records created successfully");
//        }
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
                    System.out.println();
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
    }
