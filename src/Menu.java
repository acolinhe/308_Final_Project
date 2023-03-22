import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar {
	
	public Menu() {
		Controller controller = new Controller();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		JMenu newMenu = new JMenu("New");
		JMenu editMenu = new JMenu("Edit");
		
		JCheckBoxMenuItem save = new JCheckBoxMenuItem("Save");
		JCheckBoxMenuItem load = new JCheckBoxMenuItem("Load");
		JCheckBoxMenuItem about = new JCheckBoxMenuItem("About");
		JCheckBoxMenuItem undo = new JCheckBoxMenuItem("Undo");
		JCheckBoxMenuItem clear = new JCheckBoxMenuItem("Clear");
		
		String[] itemNames = {"Begin", "End", "Call a method", "Instruction", "Input or Output", "Variable Declaration", "Condition"};
		String[] itemIcons = {"src/images/begin.png", "src/images/end.png", "src/images/call.png", "src/images/instruction.png", "src/images/inputOutput.png", "src/images/variable.png", "src/images/condition.png"};
		
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < itemNames.length; i++) {
			JCheckBoxMenuItem item = new JCheckBoxMenuItem(itemNames[i], new ImageIcon(itemIcons[i]));
			item.setHorizontalTextPosition(JCheckBoxMenuItem.RIGHT);
			item.setHorizontalAlignment(JCheckBoxMenuItem.LEFT);
			item.setIcon(new ImageIcon(new ImageIcon(itemIcons[i]).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			newMenu.add(item);
			group.add(item);
			item.addActionListener(controller);
		}
		
		
		helpMenu.add(about);
		
		
		fileMenu.add(newMenu);
		fileMenu.add(save);
		fileMenu.add(load);
		
		editMenu.add(undo);
		editMenu.add(clear);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		about.addActionListener(controller);
		undo.addActionListener(controller);
		clear.addActionListener(controller);
		
		group.add(undo);
		group.add(clear);
		
		
		setBorder(BorderFactory.createEtchedBorder());
		add(menuBar);
		
	}
	
}
