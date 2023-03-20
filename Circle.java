import java.awt.*;

public class Circle extends Shape {

    public Circle (int x1, int y1, int x2, int y2, Color c) {
        super(x1, y1, x2, y2, c);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawOval(Math.min(x2, x1), Math.min(y2, y1), (x2>x1)?x2-x1:x1-x2, (y2>y1)?y2-y1:y1-y2);
    }

    @Override
    public String decorate() {
        return super.decorate();
    }
}