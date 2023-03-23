import java.awt.*;

/**
 * The Diamond class is a subclass of the Shape class, representing a diamond shape that can be drawn on a graphics object.
 * It overrides the draw method of the Shape class to define how the diamond is drawn on the graphics object.
 * The Diamond class also inherits the x1, y1, WIDTH, HEIGHT, c, text, flag, isTextDefined variables, and methods from the Shape class.
 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class Diamond extends Shape {

    /**
     * Constructor for creating a Diamond object with the specified x1, y1, WIDTH, HEIGHT, and color values.
     * @param x1 the x-coordinate of the top left corner of the diamond.
     * @param y1 the y-coordinate of the top left corner of the diamond.
     * @param WIDTH the width of the diamond.
     * @param HEIGHT the height of the diamond.
     * @param c the color of the diamond.
     */
    public Diamond (int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    /**
     * Draws the diamond on the Graphics object.
     * @param g the Graphics object to draw the diamond on.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(3));
        int diamondSize = 150;
        int centerX = super.x1 + diamondSize / 2;
        int centerY = super.y1 + diamondSize / 2;
        int[] xPoints = {
                centerX,
                centerX + diamondSize / 2,
                centerX,
                centerX - diamondSize / 2
        };
        int[] yPoints = {
                centerY - diamondSize / 2,
                centerY,
                centerY + diamondSize / 2,
                centerY
        };
        g2d.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLACK);
        g.drawString(text, super.x1 + 50, super.y1 + 75);
    }
}