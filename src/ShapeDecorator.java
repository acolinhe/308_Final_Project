import java.awt.Color;
import java.awt.Graphics;

public abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape, int x1, int y1, int WIDTH, int HEIGHT, Color c) {
        super(x1, y1, WIDTH, HEIGHT, c);
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(Graphics g) {
        decoratedShape.draw(g);
    }

    @Override
    public int getX() {
    	return decoratedShape.getX();
    }

    @Override
    public int getY() {
    	return decoratedShape.getY();
    }

    @Override
    public int getWIDTH() {
    	return decoratedShape.getWIDTH();
    }
    
    @Override
    public int getHEIGHT() {
    	return decoratedShape.getHEIGHT();
    }

    @Override
    public void setLocation(int x, int y, int WIDTH, int HEIGHT) {
    	decoratedShape.setLocation(x, y, WIDTH, HEIGHT);
    }
}

    
