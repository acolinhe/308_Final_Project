import java.awt.*;

public class Parallelogram extends Shape {

    public Parallelogram (int x1, int y1, int x2, int y2, Color c) {
        super(x1, y1, x2, y2, c);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        int[] xPoints = {x1, x1+(x2-x1), x2, x2-(x2-x1)};
        int[] yPoints = {y1, y1+(y2-y1), y2, y2+(y1-y2)};
        g.drawPolygon(xPoints, yPoints, 4);
    }

    @Override
    public String decorate() {
        return super.decorate();
    }
}
