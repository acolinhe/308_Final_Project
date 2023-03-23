import java.awt.*;

/**
 * The VariableDecorate class draws the lines onto a rectangle for the variable object using a decorator.
 *
 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class VariableDecorate extends Rectangle {
    public VariableDecorate(int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    /**
     * Draws the lines for the variable object.
     * @param g the Graphics object to draw on
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        int x1 = getX();
        int y1 = getY();
        int width = 100;
        int height = 100;
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(2));
        g.drawLine(x1 + 10, y1 + 10, x1 + width - 10, y1 + 10);
        g.drawLine(x1 + 10, y1 + 10, x1 + 10, y1 + (height + 5) - 10);
        g2d.setStroke(oldStroke);
    }
}