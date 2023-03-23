import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * The Main class extends a built-in library, JFrame, to create a main window
 * for the Final Project program. The program is a simple flow-chart diagram.
 *
 * @author Anthony Colin, Shiv Panchal, Luke Fanguna, Nathan Choi, Reza Mousakhani, Luke Franks
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
        Repository repo = Repository.getR();
        Menu menu = new Menu();
        StatusArea status = new StatusArea();
        WorkingArea work = new WorkingArea();
        repo.addObserver(status);
        status.setBackground(Color.WHITE);
        status.setForeground(Color.BLACK);
        status.setBorder(BorderFactory.createEtchedBorder());


        setLayout(new BorderLayout());

        add(menu, BorderLayout.NORTH);
        add(status, BorderLayout.SOUTH);
        add(work, BorderLayout.CENTER);

    }
    /**
     * The main method is the for the Final Project application.
     * It sets the size of the window, sets the default close operation, and
     * makes the window visible.
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.setSize(900, 900);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setVisible(true);
    }
}