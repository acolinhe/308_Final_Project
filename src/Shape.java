import java.awt.*;


public abstract class Shape implements Decorated {
    int x1, y1, WIDTH, HEIGHT;
    Color c;
    public String text;

    private boolean flag;
    private boolean isTextDefined;

    public Shape (int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.c = c;
        text = "";
    }

    public abstract void draw(Graphics g);

    public boolean contains(Point point) {
        return point.getX() >= x1 && point.getX() <= WIDTH && point.getY() >= y1 && point.getY() <= HEIGHT;
    }

    public void move(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
//        this.WIDTH = WIDTH;
//        this.HEIGHT = HEIGHT;
    }

    public void setLocation(int x, int y){
        this.x1 = x;
        this.y1 = y;
    }

    public int getX(){
        return x1;
    }

    public int getY(){
        return y1;
    }

    @Override
    public String decorate() {
        return null;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isTextDefined() {
        return isTextDefined;
    }

    public void setTextDefined(boolean textDefined) {
        isTextDefined = textDefined;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
