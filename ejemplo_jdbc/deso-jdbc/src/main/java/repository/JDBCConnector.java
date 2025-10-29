package repository;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class JDBCConnector {

    private static JDBCConnector INSTANCE;
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "test";
    private static final String password = "test";
    private final Connection connection;



    private JDBCConnector() throws SQLException {
        connection = DriverManager.getConnection(url,user,password);
    }

    public static JDBCConnector getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new JDBCConnector();
        }
        return INSTANCE;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public PreparedStatement prepareQuery(String query) throws SQLException {
        return this.connection.prepareStatement(query);
    }
}
