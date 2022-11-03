package gRPC.assignment3_1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url="jdbc:postgresql://localhost:5432/slaughterhouse";
    private static final String user="postgres";
    private static final String password="1234";
    private static Connection databaseConnection = null;

    public static Connection getConnection() throws SQLException {
        try
        {
            databaseConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return databaseConnection;
    }
}
