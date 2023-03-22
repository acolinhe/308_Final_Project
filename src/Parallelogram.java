import java.awt.*;

public class Parallelogram extends Shape {

    public Parallelogram (int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(3));
        int[] xPoints = {x1, x1+(WIDTH-x1), WIDTH, WIDTH-(WIDTH-x1)};
        int[] yPoints = {y1, y1+(HEIGHT-y1), HEIGHT, HEIGHT+(y1-HEIGHT)};
        g2d.drawPolygon(xPoints, yPoints, 4);
    }

    @Override
    public String decorate() {
        return super.decorate();
    }
}
