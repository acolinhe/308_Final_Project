import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Menu extends JMenuBar {
	
	public Menu() {
		//Controller controller = new Controller();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		
		//JMenu shapeMenu = new JMenu("Shape");
		//JMenu lineMenu = new JMenu("Line");
		JMenu helpMenu = new JMenu("Help");
		JMenu newMenu = new JMenu("New");
		
		JCheckBoxMenuItem about = new JCheckBoxMenuItem("About");
		JCheckBoxMenuItem begin = new JCheckBoxMenuItem("Begin");
		JCheckBoxMenuItem end = new JCheckBoxMenuItem("End");
		JCheckBoxMenuItem call = new JCheckBoxMenuItem("Call a method");
		JCheckBoxMenuItem instruction = new JCheckBoxMenuItem("Instruction");
		JCheckBoxMenuItem inputOutput = new JCheckBoxMenuItem("Input or Output");
		JCheckBoxMenuItem variable = new JCheckBoxMenuItem("Variable Declaration");
		JCheckBoxMenuItem condition = new JCheckBoxMenuItem("Condition");
		
		newMenu.add(begin);
		newMenu.add(end);
		newMenu.add(call);
		newMenu.add(instruction);
		newMenu.add(inputOutput);
		newMenu.add(variable);
		newMenu.add(condition);
		
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Inheritance"));
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Using"));
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Having"));
//		lineMenu.add(lineOptions = new JCheckBoxMenuItem("Composition"));
		
		helpMenu.add(about);
		
		//shapeMenu.add(lineMenu);
		
		fileMenu.add(newMenu);
		fileMenu.add(save);
		fileMenu.add(load);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		//shapeMenu.add(lineMenu);
		
//		
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
