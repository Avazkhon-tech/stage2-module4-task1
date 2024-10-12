package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (ClassNotFoundException e) {
            System.err.println("H2 Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to create connection: " + e.getMessage());
        }
        return connection;
    }
}


