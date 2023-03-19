import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
public class Repository extends Observable {
    private Shape shape;
    private Stack<Shape> shapes;
    private Line line;
    private Stack<Line> lines;
    private static Repository repo;
    private String textbox;

    /**
     * allows Repository to not be changed out of scope
     */
    private Repository() {}
    /**
     * allows us to get the instance of the Respository
     *
     * @return instance of Repository
     */
    public static Repository getR() {
        return repo;
    }
    public void setShape(Shape shape) {this.shape = shape;}
    public void addShape(Shape shape) {shapes.push(shape);}
    public void setLine(Line line) {this.line = line;}
    public void addLine(Shape line) {lines.push(line);}
    public void setTextbox(String textbox) {this.textbox = textbox;}
    public void getTextbox(){return textbox;}

}