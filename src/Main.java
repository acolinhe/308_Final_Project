import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main extends JFrame {

	public Main() {
		super("Final Project");
		
		Menu menu = new Menu();
		StatusArea status = new StatusArea();
		WorkingArea work = new WorkingArea();
		status.setBackground(Color.WHITE);
		status.setForeground(Color.BLACK);
		status.setBorder(BorderFactory.createEtchedBorder());


		setLayout(new BorderLayout());
		
		add(menu, BorderLayout.NORTH);
		add(status, BorderLayout.SOUTH);
		add(work, BorderLayout.CENTER);
		
	}
	
	public static void main (String[] args) {
		Main m = new Main();
		m.setSize(500,500);
	    m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    m.setVisible(true);
	}
}