import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/recipe_recommender";
    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "Mysql123";

    // Get a connection to the database
    public static Connection getConnection() throws SQLException {
    	
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
