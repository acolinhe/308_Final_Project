import java.awt.*;

/**
 * The Rectangle class represents a rectangle shape that extends from the Shape class. It inherits the properties
 * and methods of the Shape class and overrides the draw method to draw a rectangle using the given coordinates and
 * color.

 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class Rectangle extends Shape {

    /**
     * Constructor for creating a Diamond object with the specified x1, y1, WIDTH, HEIGHT, and color values.
     * @param x1 the x-coordinate of the top left corner of the diamond.
     * @param y1 the y-coordinate of the top left corner of the diamond.
     * @param WIDTH the width of the diamond.
     * @param HEIGHT the height of the diamond.
     * @param c the color of the diamond.
     */
    public Rectangle (int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    /**
     * Draws the rectangle on a Graphics object.
     * @param g the Graphics object to draw on
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(super.x1, super.y1, 100, 100);
        g.setColor(Color.BLACK);
        g.drawString(text,super.x1+35,super.y1+45);

    }
}
