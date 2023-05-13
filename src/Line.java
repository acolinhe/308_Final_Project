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
    RepositoryInterface repo = Repository.getR();

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
        g.setColor(Color.BLACK);
        Point start = center(connect.get(0));
        Point end = center(connect.get(1));
        int startx=start.x,starty=start.y,endx=end.x,endy=end.y;
        if (start.y+50 < end.y && start.y-50 > end.y)
        {
            endx = end.x;
            endy = end.y;
        }
        else if (start.y+50 < end.y)
        {
            endx = end.x;
            endy = end.y-40;
        }
        else
        {
            endx = end.x;
            endy = end.y+40;
        }
        if (start.x + 50 > end.x && start.x - 50 < end.x)
        {
            startx = start.x;
            if (start.y + 50 < end.y)
                starty = start.y + 50;
            else if (start.y - 50 > end.y)
                starty = start.y - 50;
        }
        else if (start.x + 50 < end.x)
        {
            startx = start.x + 50;
            starty = start.y;
        }
        else if (start.x - 50 > end.x)
        {
            startx = start.x - 50;
            starty = start.y;
        }
        g.drawLine(startx, starty, endx, endy);

        // Calculate the midpoint and angle of the line segment
        int midX = (startx + endx) / 2;
        int midY = (starty + endy) / 2;
        double angle = Math.atan2(endy - starty, endx - startx);

        // Calculate the coordinates of the arrowhead vertices
        int arrowSize = 10;
        int arrowAngle = 30; // in degrees
        double arrowLength = arrowSize / Math.sin(Math.toRadians(arrowAngle));
        int arrowX1 = (int) (endx - arrowLength * Math.cos(angle - Math.toRadians(arrowAngle)));
        int arrowY1 = (int) (endy - arrowLength * Math.sin(angle - Math.toRadians(arrowAngle)));
        int arrowX2 = (int) (endx - arrowLength * Math.cos(angle + Math.toRadians(arrowAngle)));
        int arrowY2 = (int) (endy - arrowLength * Math.sin(angle + Math.toRadians(arrowAngle)));

        // Draw the arrowhead polygon
        int[] arrowX = {endx, arrowX1, arrowX2};
        int[] arrowY = {endy, arrowY1, arrowY2};
        g.fillPolygon(arrowX, arrowY, 3);


        if (diamond) {
            if (connect.get(0).toString().contains("Diamond")) {
                if (flag) {
                    repo.setTextbox("true");
                } else {
                    repo.setTextbox("false");
                }
            }
        } else {
            repo.setTextbox("");
        }
        g.drawString(repo.getTextbox(), arrowX1, arrowY1 + 25);
    }

    /**
     * This helps the line to point to the center of the shape
     *
     * @param x this is the shape object which we are making the center of
     * @return return a point object that is the center of the shapes
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
     *
     * @param flag boolean variable to set the flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
