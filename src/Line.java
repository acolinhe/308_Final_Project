import java.awt.*;
import java.util.*;

public class Line implements LineInterface
{
    Stack<String> message;
    Line()
    {
        message.push(" ");
        message.push("true");
        message.push("false");
    }
    public void draw(Graphics g)
    {
        Stack<Shape> connect = Repository.getR().getC();
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
        int arrowX1 = (int)(midX - arrowLength * Math.cos(angle - Math.toRadians(arrowAngle)));
        int arrowY1 = (int)(midY - arrowLength * Math.sin(angle - Math.toRadians(arrowAngle)));
        int arrowX2 = (int)(midX - arrowLength * Math.cos(angle + Math.toRadians(arrowAngle)));
        int arrowY2 = (int)(midY - arrowLength * Math.sin(angle + Math.toRadians(arrowAngle)));

        // Draw the arrowhead polygon
        int[] arrowX = {midX, arrowX1, arrowX2};
        int[] arrowY = {midY, arrowY1, arrowY2};
        g.fillPolygon(arrowX, arrowY, 3);
    }
    private Point center(Shape x) {
        return new Point(x.x1 + (x.x1 + x.x2) / 2, x.y1 + (x.x2 + x.y2) / 2);
    }
    public void lineMessage(Graphics g)
    {
        Stack<Shape> connect = Repository.getR().getC();
        Point start = center(connect.get(0));
        Point end = center(connect.get(1));
        if (connect.get(0).equals("Diamond")) {
            String text = message.pop();
            g.drawString(text, (start.x-end.x)/2,(start.y-end.y)/2);
            message.push(text);
        }
    }
}
