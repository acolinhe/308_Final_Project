import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * The Main class extends a built-in library, JFrame, to create a main window
 * for the Final Project program. The program is a simple flow-chart diagram.
 *
 * @author Anthony Colin, Shiv Panchal, Luke Fanguna, Nathan Choi, Reza Mousakhani, Luke Franks.
 */
public class Main extends JFrame {
    /**
     * Constructor for the Main class. Sets the title of the window and initializes the
     * Repository, Menu, StatusArea, and WorkingArea classes. The StatusArea and WorkingArea
     * classes are added as observers to the Repository. The Menu, StatusArea, and WorkingArea
     * classes are added to the main window in BorderLayout.
     */
    public Main() {
        super("Final Project");
        Menu menu = new Menu();
        StatusArea status = new StatusArea();
        WorkingArea work = new WorkingArea();
        ChatArea chat = new ChatArea();
        status.setBackground(Color.WHITE);
        status.setForeground(Color.BLACK);
        status.setBorder(BorderFactory.createEtchedBorder());

        setLayout(new BorderLayout());

        JPanel textAreaPanel = new JPanel(new GridLayout(2, 1));
        JPanel qaPanel = new JPanel(new GridLayout(2, 1));

        JTextArea questionTextArea = new JTextArea(5, 30);
        questionTextArea.setBorder(BorderFactory.createTitledBorder("Question"));
        JTextArea answerTextArea1 = new JTextArea(3, 30);
        answerTextArea1.setBorder(BorderFactory.createTitledBorder("Answer Subsection 1"));
        JTextArea answerTextArea2 = new JTextArea(3, 30);
        answerTextArea2.setBorder(BorderFactory.createTitledBorder("Answer Subsection 2"));
        JTextArea answerTextArea3 = new JTextArea(3, 30);
        answerTextArea3.setBorder(BorderFactory.createTitledBorder("Answer Subsection 3"));
        JTextArea answerTextArea4 = new JTextArea(3, 30);
        answerTextArea4.setBorder(BorderFactory.createTitledBorder("Answer Subsection 4"));

        qaPanel.add(questionTextArea);
        JPanel answerSubsectionsPanel = new JPanel(new GridLayout(2, 2));
        answerSubsectionsPanel.add(answerTextArea1);
        answerSubsectionsPanel.add(answerTextArea2);
        answerSubsectionsPanel.add(answerTextArea3);
        answerSubsectionsPanel.add(answerTextArea4);
        qaPanel.add(answerSubsectionsPanel);

        textAreaPanel.add(qaPanel);
        textAreaPanel.add(chat);
        add(menu, BorderLayout.NORTH);
        add(textAreaPanel, BorderLayout.WEST);
        add(work, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
    }

    /**
     * The main method is the for the Final Project application.
     * It sets the size of the window, sets the default close operation, and
     * makes the window visible.
     */
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        Main m = new Main();
        m.setSize(1500, 1500);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setVisible(true);

        // For DB testing. Will remove.
        new LoginCredentials().changePassword("mooser", "IHaveAPoopyButthole1",
                "IHaveACleanButthole1");
    }
}