
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.Stack;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    public void shapePushedInStack(){
        Repository.getR().addShape(new Rectangle(50, 100, 50, 100, Color.BLACK));
        Repository.getR().addShape(new Circle(50, 100, 50, 100, Color.BLACK));
        Repository.getR().addShape(new Diamond(50, 100, 50, 100, Color.BLACK));

        assertEquals("Rectangle", Repository.getR().getShapes().get(0).getClass().getName());
        assertEquals("Circle", Repository.getR().getShapes().get(1).getClass().getName());
        assertEquals("Diamond", Repository.getR().getShapes().get(2).getClass().getName());
    }


    @Test
    public void shapeClearedPushedInStack(){
        Repository.getR().getShapes().clear();
        Stack<Shape> s = new Stack<>();
        assertEquals(s, Repository.getR().getShapes());
    }

    @Test
    public void decoratedShapePushedInStack(){
        Shape circle = new Circle(50, 100, 50, 100, Color.BLACK);
        Repository.getR().addShape(new FillDecorator(circle,50, 100, 50, 100, Color.BLACK));
        Shape rectangle = new Rectangle(50, 100, 50, 100, Color.BLACK);
        Repository.getR().addShape(new CallDecorator(rectangle,50, 100, 50, 100, Color.BLACK));
        Repository.getR().addShape(new VariableDecorate(rectangle,50, 100, 50, 100, Color.BLACK));

        assertEquals("FillDecorator", Repository.getR().getShapes().get(0).getClass().getName());
        assertEquals("CallDecorator", Repository.getR().getShapes().get(1).getClass().getName());
        assertEquals("VariableDecorate", Repository.getR().getShapes().get(2).getClass().getName());
    }

    @Test
    public void decoratedShapeClearedPushedInStack(){
        Repository.getR().getShapes().clear();
        Stack<Shape> s = new Stack<>();
        assertEquals(s, Repository.getR().getShapes());
    }

}