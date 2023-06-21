package org.jdbc;
public class Main {
    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();

        connector.connection();
        connector.selectAllBooks();
    }
}
