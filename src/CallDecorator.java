import java.awt.*;

/**
 * The CallDecorator class draws the lines onto a rectangle for the call object using a decorator.
 *
 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class CallDecorator extends Rectangle {
    public CallDecorator(int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    /**
     * Draws the lines for the call object.
     * @param g the Graphics object to draw on
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        int x1 = getX();
        int y1 = getY();
        int height = 100;
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(2));
        g.drawLine(x1 + 10, y1, x1 + 10, y1 + height);
        g.drawLine(x1 + 90, y1, x1 + 90, y1 + height);
        g2d.setStroke(oldStroke);
    }
}