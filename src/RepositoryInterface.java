import java.util.Stack;

public interface RepositoryInterface
{

    /**
     * SetLoadShapes takes the shapes from the loaded file
     * and sets the shapes stack above with those shapes
     *
     * @param: stack of objects to be loaded
     */
    public void setLoadShapes(Stack<Shape> newShapes);

    /**
     * Sets the shape field to the value passed in
     *
     * @param shape to be used
     */
    public void setShape(String shape);

    /**
     * Adds a shape to the stack
     *
     * @param shape
     */
    public void addShape(Shape shape);

    /**
     * Sets the line field to the value passed in
     *
     * @param line
     */
    public void setLine(Line line);
    /**
     * Adds the line value to the stack
     *
     * @param line
     */
    public void addLine(Line line);

    /**
     * Sets the textbox of the shape to the value passed in
     *
     * @param textbox
     */
    public void setTextbox(String textbox);
    /**
     * Adds a shape to the connection stack that helps make lines
     *
     * @param shape
     */
    public void addC(Shape shape);

    /**
     * Gets the shape stack
     *
     * @return stack of shapes
     */
    public Stack<Shape> getShapes();

    /**
     * Gets the stack of lines
     *
     * @return stack of lines
     */
    public Stack<Line> getLines();

    /**
     * Gets the connection stack that helps build lines
     *
     * @return stack of shapes
     */
    public Stack<Shape> getC();

    /**
     * Clears the connection stack
     */
    public void clearC();

    /**
     * Gets the Textbox within a shape
     *
     * @return textbox of a shape
     */
    public String getTextbox();


    /**
     * Gets the shape stored
     *
     * @return shape object stored
     */
    public String getShape();

    /**
     * Puts all the objects into one stack
     */
    public void setAll();

    /**
     * Puts all objects into all stack
     *
     * @return stack of objects
     */
    public Stack<Object> getAll();
}
