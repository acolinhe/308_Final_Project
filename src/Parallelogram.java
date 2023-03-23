import java.awt.*;

public class Parallelogram extends Shape {
    private static final int WIDTH = 150;
    private static final int HEIGHT = 100;

    /**
     * The Parallelogram class represents a parallelogram shape that extends from the Shape class. It inherits the properties
     * and methods of the Shape class and overrides the draw method to draw a parallelogram using the given coordinates and
     * color.
     *
     * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
     */
    public Parallelogram(int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    /**
     * Draws the diamond on the Graphics object.
     *
     * @param g the Graphics object to draw the diamond on.
     */

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(3));

        int yDiff = (int) (Math.sin(Math.toRadians(45)) * HEIGHT); // calculate difference in y-coordinates
        int[] xPoints = {super.x1, super.x1 + WIDTH, super.x1 + WIDTH - yDiff, super.x1 - yDiff};
        int[] yPoints = {super.y1, super.y1, super.y1 + HEIGHT, super.y1 + HEIGHT};
        Polygon parallelogram = new Polygon(xPoints, yPoints, 4);
        g2d.fill(parallelogram);
        g.setColor(Color.BLACK);
        g.drawString(text, super.x1 + 35, super.y1 + 45);
    }
}
