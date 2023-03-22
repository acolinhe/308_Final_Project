import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import javax.swing.JPanel;

public class WorkingArea extends JPanel implements Observer{

	Repository repo;
	
	public WorkingArea() {
		repo = Repository.getR();
		Controller controller = new Controller();
		Repository.getR().setShape("Begin");
		setBackground(Color.LIGHT_GRAY);
		addMouseListener(controller);
		addMouseMotionListener(controller);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Shape drawing : repo.getShapes()) {
			drawing.draw(g);
		}
		repaint();
	}

	public void update(Observable o, Object arg){
		updateShapes();
	}

	public void updateShapes(){
		repaint();
	}


}