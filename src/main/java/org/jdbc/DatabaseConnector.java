package org.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseConnector {
    public Connection connection() {
        Connection connection = null;

        try {
            String url = "jdbc:sqlite:C:\\Users\\admin\\Documents\\FullStack104\\SQLite\\Bookstore.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    public void selectAllBooks() {
        String sql = "SELECT * FROM Books";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.connection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title") + "\t" +
                        resultSet.getString("author") + "\t" +
                        resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing SELECT statement");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error closing the database resources.");
                e.printStackTrace();
            }
        }
    }
}
