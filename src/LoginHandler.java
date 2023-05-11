import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginHandler implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JFrame loginWindow;

    public LoginHandler(JTextField usernameField, JPasswordField passwordField, JFrame loginWindow) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.loginWindow = loginWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            LoginCredentials credentials = new LoginCredentials();
            boolean loggedIn = credentials.userLogin(username, password);

            if (loggedIn) {
                System.out.println("Login successful!");
                loginWindow.setVisible(false);
            } else {
                ImageIcon icon = new ImageIcon("src/images/pepeSize.png");
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE, icon);
            }
        } catch (SQLException | NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}

