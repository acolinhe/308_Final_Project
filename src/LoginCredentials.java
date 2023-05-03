import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCredentials extends DBConn {
    // Will delete this
//    public void tryConnect() throws SQLException, NoSuchAlgorithmException {
//        String sql = " SELECT * FROM Users ";
//        Statement statement = conn.createStatement();
//        ResultSet result = statement.executeQuery(sql);
//
//        while (result.next()) {
//            String name = result.getString("pass");
//            System.out.println(name);
//            System.out.println(hashPasswords(name));
//        }
//    }

    public void createUser(String username, String password, String email) throws SQLException, NoSuchAlgorithmException {
        String sql = " INSERT INTO Users (username, pass, email) VALUES (?, ?, ?)";
        String hashedPass = hashPasswords(password);
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, username);
        statement.setString(2, hashedPass);
        statement.setString(3, email);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }

    }

    private static String hashPasswords(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public LoginCredentials() throws SQLException {
    }
}
