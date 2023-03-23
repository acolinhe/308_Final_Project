import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.swing.*;
/**
 * The Menu class extends JMenuBar and provides a graphical user interface for a menu bar.
 * It consists of various menu items. Moreover, the class provides functionalities to save
 * and load diagrams, set action listeners, and icons for menu items.
 *
 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class Menu extends JMenuBar {
	/**
	 * Creates a new Menu object with File, Help, New and Edit menus, and their respective menu items.
	 * Additionally, it sets the appropriate action listeners for each menu item and creates
	 * the necessary icons for display.
	 */
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
			item.addActionListener(controller);
			group.add(item);
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

		String filePath = getDesktopPath() + "diagram.bin";
		save.addActionListener(e -> {
			try {
				Repository.getR().setAll();
				LoadOrSave.saveObjects(Repository.getR().getAll(), filePath);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		load.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Load Diagram");
			int userSelect = fileChooser.showOpenDialog(this);
			if (userSelect == JFileChooser.APPROVE_OPTION){
				try {
					Stack<Shape> loadedShapes = LoadOrSave.loadObjects(filePath);
					Repository.getR().setLoadShapes(loadedShapes);
				} catch (IOException | ClassNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		
		setBorder(BorderFactory.createEtchedBorder());
		add(menuBar);
		
	}

	/**
	 * Gets desktop path for the file to be saved in
	 * @return desktop directory
	 */
	private static String getDesktopPath() {
		String home = System.getProperty("user.home");
		return home + File.separator + "Desktop" + File.separator;
	}
}
