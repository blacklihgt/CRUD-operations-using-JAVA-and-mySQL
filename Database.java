import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Database {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/java"; // replace "mydatabase" with your database name
            String username = "root"; // replace with your database username
            String password = "Roykibet01"; // replace with your database password
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");

            // Perform CRUD operations
            // Create a new record
            String insertSql = "INSERT INTO worker (name_Id, last_name, phone_number) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, "Roy Kibet");
            insertStmt.setString(2, "Langat");
            insertStmt.setString(3, "0748222793");
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println(rowsInserted + " rows inserted");

           
            // Update a record
           
            
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close database connection");
                e.printStackTrace();
            }
        }
    }
}
