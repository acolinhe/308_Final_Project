import java.awt.*;

/**
 * The VariableDecorate class draws the lines onto a rectangle for the variable object using a decorator.
 *
 * @author Reza Mousakhani, Anthony Colin, Luke Fanguna, Luke Franks, Nathan Choi, & Shiv Panchal
 */
public class VariableDecorate extends ShapeDecorator {

    public VariableDecorate(Shape decoratedShape, int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(decoratedShape, x1, y1, WIDTH, HEIGHT, c);
    }

    @Override
    public void draw(Graphics g) {
        decoratedShape.draw(g);
        drawVariableLines(g);
    }

    private void drawVariableLines(Graphics g) {
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
        g.drawString(text,super.x1+35,super.y1+45);
        g2d.setStroke(oldStroke);
    }
}