import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar {
	
	public Menu() {
		//Controller controller = new Controller();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		JMenu newMenu = new JMenu("New");
		
		JCheckBoxMenuItem save = new JCheckBoxMenuItem("Save");
		JCheckBoxMenuItem load = new JCheckBoxMenuItem("Load");
		JCheckBoxMenuItem about = new JCheckBoxMenuItem("About");
		
		List<JCheckBoxMenuItem> items = new ArrayList<>();
		items.add(new JCheckBoxMenuItem("Begin", new ImageIcon("./src/images/begin.png")));
		items.add(new JCheckBoxMenuItem("End", new ImageIcon("./src/images/end.png")));
		items.add(new JCheckBoxMenuItem("Call a method", new ImageIcon("./src/images/call.png")));
		items.add(new JCheckBoxMenuItem("Instruction", new ImageIcon("./src/images/instruction.png")));
		items.add(new JCheckBoxMenuItem("Input or Output", new ImageIcon("./src/images/inputOutput.png")));
		items.add(new JCheckBoxMenuItem("Variable Declaration", new ImageIcon("./src/images/variable.png")));
		items.add(new JCheckBoxMenuItem("Condition", new ImageIcon("./src/images/condition.png")));
		
		for (JCheckBoxMenuItem item : items) {
		    item.setHorizontalTextPosition(JCheckBoxMenuItem.RIGHT);
		    item.setHorizontalAlignment(JCheckBoxMenuItem.LEFT);
		    item.setIcon(new ImageIcon(((ImageIcon) item.getIcon()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		    newMenu.add(item);
		}
		
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Inheritance"));
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Using"));
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Having"));
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Composition"));
		
		helpMenu.add(about);
		
		
		fileMenu.add(newMenu);
		fileMenu.add(save);
		fileMenu.add(load);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
//		about.addActionListener(controller);
//		begin.addActionListener(controller);
//		end.addActionListener(controller);
//		call.addActionListener(controller);
//		instruction.addActionListener(controller);
//		inputOutput.addActionListener(controller);
//		variable.addActionListener(controller);
//		condition.addActionListener(controller);
		
		setBorder(BorderFactory.createEtchedBorder());
		add(menuBar);
		
	}
	

}
