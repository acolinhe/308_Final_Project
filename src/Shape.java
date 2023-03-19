import java.awt.*;


public abstract class Shape implements Decorated{
    int x1, y1, x2, y2;
    Color c;

    public Shape (int x1, int y1, int x2, int y2, Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c = c;
    }

    public abstract void draw(Graphics g);
}
