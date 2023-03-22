import java.awt.*;

public class Rectangle extends Shape {


    public Rectangle (int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawRect(super.x1, super.y1, 100, 100);
        g.drawString(text,super.x1+35,super.y1+50);

    }

    @Override
    public String decorate() {
        return super.decorate();
    }


}
