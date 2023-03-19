import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusArea extends JPanel  {
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
		
	
	public void update(Observable o, Object arg) {
		
		//modify this
		//status.setText();
		
	}
	
}
