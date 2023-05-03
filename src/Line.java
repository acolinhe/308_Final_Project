import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

/**
 * This is the line class that helps create lines between two shapes
 *
 * @author Anthony Colin, Shiv Panchal, Luke Fanguna, Nathan Choi, Reza Mousakhani, Luke Franks
 */
public class Line implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    boolean diamond = false;
    boolean flag;
    Stack<String> message = new Stack<>();
    Stack<Shape> connect = new Stack<Shape>();

    /**
     * This is the constructor that helps initialize variables for the Line class
     *
     * @param first  shape to create the connection
     * @param second shape to create the connection
     */
    Line(Shape first, Shape second) {
        message.push("");
        message.push("true");
        message.push("false");
        connect.push(first);
        connect.push(second);

    }

    /**
     * This is the draw class that uses Graphics g to draw a line with an arrow head in the middle to show direction.
     * Also, it checks if the connection starts with a diamond and if it does, we add text to it
     *
     * @param g the Graphics object to draw on
     */
    public void draw(Graphics g) {
        String str = "";

        Point start = center(connect.get(0));
        Point end = center(connect.get(1));
        g.drawLine(start.x, start.y, end.x, end.y);

        // Calculate the midpoint and angle of the line segment
        int midX = (start.x + end.x) / 2;
        int midY = (start.y + end.y) / 2;
        double angle = Math.atan2(end.y - start.y, end.x - start.x);

        // Calculate the coordinates of the arrowhead vertices
        int arrowSize = 10;
        int arrowAngle = 30; // in degrees
        double arrowLength = arrowSize / Math.sin(Math.toRadians(arrowAngle));
        int arrowX1 = (int) (midX - arrowLength * Math.cos(angle - Math.toRadians(arrowAngle)));
        int arrowY1 = (int) (midY - arrowLength * Math.sin(angle - Math.toRadians(arrowAngle)));
        int arrowX2 = (int) (midX - arrowLength * Math.cos(angle + Math.toRadians(arrowAngle)));
        int arrowY2 = (int) (midY - arrowLength * Math.sin(angle + Math.toRadians(arrowAngle)));

        // Draw the arrowhead polygon
        int[] arrowX = {midX, arrowX1, arrowX2};
        int[] arrowY = {midY, arrowY1, arrowY2};
        g.fillPolygon(arrowX, arrowY, 3);


        if (diamond) {
            if (connect.get(0).toString().contains("Diamond")) {
                int[] textArrow = {midY, arrowY1 + 25, arrowY2};
                if (flag) {
                    Repository.getR().setTextbox("false");

                } else {
                    Repository.getR().setTextbox("true");
                }
            }
        } else {
            Repository.getR().setTextbox("");
        }
        g.drawString(Repository.getR().getTextbox(), arrowX1, arrowY1 + 25);
    }

    /**
     * This helps the line to point to the center of the shape
     *
     * @param x this is the shape object which we are making the center of
     * @return returns a point object that is the center of the shape
     */
    private Point center(Shape x) {
        return new Point(x.x1+50, x.y1+50);
    }

    /**
     * This creates a message that changes the  text on the line if the connection starts
     * with a diamond
     *
     * @param cond boolean that sets the diamond
     */
    public void lineMessage(boolean cond) {
        diamond = cond;
    }

    /**
     * This sets the flag we use to alternate the text of the line
     *
     * @param flag boolean variable to set the flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
