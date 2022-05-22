import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
// This class can be used to initialize the database connection
public class DatabaseConnection {
	Connection con;
    public DatabaseConnection()
        throws SQLException
    {
        // Initialize all the information regarding
        // Database Connection
      //  String dbDriver = "com.mysql.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String dbName = "javaproposal";
        String dbUsername = "root";
        String dbPassword = "";
  
     //   Class.forName(dbDriver);
        con = DriverManager.getConnection(dbURL + dbName, dbUsername,  dbPassword);
                                                    
                                                    
      
    }
}