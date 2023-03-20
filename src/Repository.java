import java.util.*;
import java.util.Observable;
public class Repository extends Observable {
    private String shape;
    private Stack<Shape> shapes = new Stack<Shape>();
    private Line line;
    private Stack<Line> lines = new Stack<Line>();
    private Stack<Shape> connection = new Stack<Shape>();
    private static Repository repo;
    private String textbox;

    /**
     * allows Repository to not be changed out of scope
     */
    private Repository(){}
    /**
     * allows us to get the instance of the Respository
     *
     * @return instance of Repository
     */
    public static Repository getR()
    {
        if (repo == null)
        {
            repo = new Repository();
        }
        return repo;
    }
    public void setShape(String shape) {this.shape = shape;}
    public void addShape(Shape shape) {shapes.push(shape);}
    public void setLine(Line line) {this.line = line;}
    public void addLine(Line line) {lines.push(line);}
    public void setTextbox(String textbox) {this.textbox = textbox;}
    public void addC(Shape shape){connection.push(shape);}
    public Stack<Shape> getShapes() {return shapes;}
    public Stack<Line> getLines() {return lines;}
    public Stack<Shape> getC() {return connection;}
    public void clearC() {connection.clear();}
    public String getTextbox(){return textbox;}
    public int getShapeSize(){return shapes.size();}
    public Shape getElement(int i){return shapes.get(i);}
    public String getShape(){return shape;}

}