import java.awt.*;

/**
 * The FillDecorator class fills in a circle object using a decorator.
 *
 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class FillDecorator extends Circle {

    public FillDecorator(int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    /**
     * Fills in the circle to create an end point.
     *
     * @param g the Graphics object to draw the diamond on.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.fillOval(super.x1, super.y1, 100, 100);
        g2d.setColor(Color.WHITE);
        g2d.drawString("End", super.x1 + 35, super.y1 + 55);
    }
}

