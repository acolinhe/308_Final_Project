import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class StatusArea extends JPanel implements Observer {
	JTextArea status;
	//Repository repo;
	
	public StatusArea() {
		status = new JTextArea("Status: ");
		status.setEditable(false);
		status.setBackground(Color.WHITE);
		status.setBorder(BorderFactory.createEmptyBorder());
		//status.setHorizontalAlignment(JTextArea.LEFT);
		status.setForeground(Color.BLACK);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		status.setText("Status: Shiv is a 🐐");
		add(status);
		
		//repo.addObserver(this);
	}
		
	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("Shape")) {
			status.setText("Status: Shape Was Created");
		}
		else if (arg.equals("Line")) {
			status.setText("Status: Line Was Created");
		}
		else if (arg.equals("Save")) {
			status.setText("Status: File Was Saved");
		}
		else if (arg.equals("Load")) {
			status.setText("Status: File Was Loaded");
		}
	}
	
}
