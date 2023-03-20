import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WorkingArea extends JPanel{
	
	public WorkingArea() {
//		Controller controller = new Controller();
		setBackground(Color.LIGHT_GRAY);
//		addMouseListener(controller);
//		addMouseMotionListener(controller);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//        
//		for (Draw drawing : repository.get()) {
//            drawing.draw(g);
//      }
//  }
//
//  @Override
//  public void update(Observable o, Object arg) {
//  	repaint();
//  }
	}
}