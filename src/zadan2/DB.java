package zadan2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
    public static Connection connect() throws SQLException {

        try {
            // Get database credentials from DatabaseConfig class
            var jdbcUrl = DatabaseConfig.getDbUrl();
            var user = DatabaseConfig.getDbUsername();
            var password = DatabaseConfig.getDbPassword();

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public void openConnection() {
    try (var connection =  DB.connect()){
        System.out.println("Connected to the PostgreSQL database.");
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    }
    
    public void closeConnection() {
    	try { 
            var jdbcUrl = DatabaseConfig.getDbUrl();
            var user = DatabaseConfig.getDbUsername();
            var password = DatabaseConfig.getDbPassword();
    		
    		DriverManager.getConnection(jdbcUrl, user, password).close();
    		System.out.println("Zamknięto połączenie");
        } catch (SQLException  e) {
            System.err.println("Error closing connection: " + e.getMessage());
            
    }
}
}
