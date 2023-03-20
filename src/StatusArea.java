import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusArea extends JPanel implements Observer {
	JTextField status;
	//Repository repo;
	
	public StatusArea() {
		status = new JTextField("Status: ");
		status.setEditable(false);
		status.setBackground(Color.WHITE);
		status.setBorder(BorderFactory.createEmptyBorder());
		status.setHorizontalAlignment(JTextField.LEFT);
		status.setForeground(Color.BLACK);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(status);
		
		//repo.addObserver(this);
	}
		
	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("Shape")) {
			System.out.println("chat panel print: shape was created");
		}
		else if (arg.equals("Line")) {
			System.out.println("chat panel print: line was created");
		}
		//modify this
		//status.setText();
		
	}
	
}
