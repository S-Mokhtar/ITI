package team4.tictactoe.backend.config;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;

    public DBConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/tictactoedb", "root", "H3llst0orm!");
        if (conn != null) {
            connection = conn;
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
