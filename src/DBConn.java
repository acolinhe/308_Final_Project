import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Rectangle class represents a rectangle shape that extends from the Shape class. It inherits the properties
 * and methods of the Shape class and overrides the draw method to draw a rectangle using the given coordinates and
 * color.

 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */

public class DBConn {
    String DB = System.getenv("DB");
    String USER = System.getenv("USERNAME");
    String HOST = System.getenv("HOST");
    String PASS = System.getenv("PASSWORD");

    Connection conn = DriverManager.getConnection(HOST, USER, PASS);

    public DBConn() throws SQLException {
    }
}
