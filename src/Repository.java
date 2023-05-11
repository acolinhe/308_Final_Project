import javax.swing.*;
import java.io.File;
import java.util.*;
import java.util.Observable;

/**
 * This is the repository. It stores common variables held by other classes and uses a Singleton and an Observer Pattern
 *
 * @author Anthony Colin, Shiv Panchal, Luke Fanguna, Nathan Choi, Reza Mousakhani, Luke Franks
 */
public class Repository extends Observable implements RepositoryInterface{
    private String filePath = getDesktopPath() + "diagram.bin";
    private String shape;
    private boolean lineFlag = false;
    private Stack<Shape> shapes = new Stack<Shape>();
    private Line line;
    private Stack<Line> lines = new Stack<Line>();
    private Stack<Shape> connection = new Stack<Shape>();
    private Stack<Object> all = new Stack<>();
    private static Repository repo;
    private String textbox;
    private JTextPane chatTextArea;
    private JTextField messageTextField;


    /**
     * Allows Repository to not be changed out of scope
     */
    private Repository() {
    }

    /**
     * Gets desktop path for the file to be saved in
     * @return desktop directory
     */
    private static String getDesktopPath() {
        String home = System.getProperty("user.home");
        return home + File.separator + "Desktop" + File.separator;
    }

    public String getFilePath(){
        return filePath;
    }

    /**
     * Allows us to get the instance of the Respository
     *
     * @return instance of Repository
     */
    public static Repository getR() {
        if (repo == null) {
            repo = new Repository();
        }
        return repo;
    }

    /**
     * SetLoadShapes takes the shapes from the loaded file
     * and sets the shapes stack above with those shapes
     *
     * @param: stack of objects to be loaded
     */
    public void setLoadShapes(Stack<Shape> newShapes) {
        shapes = newShapes;
        setChanged();
        notifyObservers("Load");
    }

    public void setLoadLines(Stack<Line> newLines) {
        lines = newLines;
        setChanged();
        notifyObservers("Load");
    }

    /**
     * Sets the shape field to the value passed in
     *
     * @param shape to be used
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Adds a shape to the stack
     *
     * @param shape
     */
    public void addShape(Shape shape) {
        shapes.push(shape);
        setChanged();
        notifyObservers("Shape");
    }

    /**
     * Sets the line field to the value passed in
     *
     * @param line
     */
    public void setLine(Line line) {
        this.line = line;
    }

    /**
     * Adds the line value to the stack
     *
     * @param line
     */
    public void addLine(Line line) {
        lines.push(line);
        setChanged();
        notifyObservers("Line");

    }

    /**
     * Sets the textbox of the shape to the value passed in
     *
     * @param textbox
     */
    public void setTextbox(String textbox) {
        this.textbox = textbox;
    }

    /**
     * Adds a shape to the connection stack that helps make lines
     *
     * @param shape
     */
    public void addC(Shape shape) {
        connection.push(shape);
    }

    /**
     * Gets the shape stack
     *
     * @return stack of shapes
     */
    public Stack<Shape> getShapes() {
        return shapes;
    }

    /**
     * Gets the stack of lines
     *
     * @return stack of lines
     */
    public Stack<Line> getLines() {
        return lines;
    }

    /**
     * Gets the connection stack that helps build lines
     *
     * @return stack of shapes
     */
    public Stack<Shape> getC() {
        return connection;
    }

    /**
     * Clears the connection stack
     */
    public void clearC() {
        connection.clear();
    }

    /**
     * Gets the Textbox within a shape
     *
     * @return textbox of a shape
     */
    public String getTextbox() {
        return textbox;
    }


    /**
     * Gets the shape stored
     *
     * @return shape object stored
     */
    public String getShape() {
        return shape;
    }

    /**
     * Puts all the objects into one stack
     */
    public void setAll() {
        for (Object object : shapes) {
            all.push(object);
        }
        for (Object object : connection) {
            all.push(object);
        }
        for (Object object : lines) {
            all.push(object);
        }
    }

    /**
     * Puts all objects into all stack
     *
     * @return stack of objects
     */
    public Stack<Object> getAll() {
        return all;
    }

    public void setChatTextArea(){
        this.chatTextArea = new JTextPane();
    }
    public void setMessageTextField(){
        this.messageTextField = new JTextField();
    }

    public JTextPane getChatTextArea(){
        return repo.chatTextArea;
    }

    public JTextField getMessageTextField(){
        return repo.messageTextField;
    }
}
