import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dmytro on 16.06.2015.
 */
public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";


    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker() {
        try {
            connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
