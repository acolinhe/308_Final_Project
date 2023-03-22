import java.awt.*;

public class Circle extends Shape {

    public Circle (int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(Math.min(WIDTH, x1), Math.min(HEIGHT, y1), (WIDTH>x1)?WIDTH-x1:x1-WIDTH, (HEIGHT>y1)?HEIGHT-y1:y1-HEIGHT);
    }

    @Override
    public String decorate() {
        return super.decorate();
    }
}