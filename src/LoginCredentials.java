import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCredentials extends DBConn {
    public void tryConnect() throws SQLException {
        String sql = " SELECT * FROM Users ";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String name = result.getString("username");
            System.out.println(name);
        }
    }

    public LoginCredentials() throws SQLException {
    }
}
