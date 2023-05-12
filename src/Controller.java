import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

/**
 * This is the controller. This class represents all the controls of the entire program overall.
 * This class Inherits the properties and methods of ActionListener, MouseListener and MouseMotionListener.
 *
 * @author Anthony Colin, Shiv Panchal, Luke Fanguna, Nathan Choi, Reza Mousakhani, Luke Franks
 */
public class Controller extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private Color color = Color.WHITE;
    private int x1, y1;
    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    private Point prevPoint;
    private int count = 0;
    boolean exist = false;
    private String shape;
    private RepositoryInterface repo = Repository.getR();
    private QuestionArea questionArea;


    /**
     * Method below is inherited from ActionListener. It gets inputs from checkboxes which user operates With.
     * It sets to different operations using getActionCommand().
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        String[] shapeArr = {"Begin", "End", "Call a method", "Instruction", "Input or Output", "Variable Declaration", "Condition"};
        for (String shape : shapeArr) {
            if (action.equals(shape)) {
                Repository.getR().setShape(shape);
            }
        }

        switch (action) {
            case "Undo":
                undo();
                break;
            case "Clear":
                clear();
                break;
            case "About":
                AboutArea ab = new AboutArea();
                ab.aboutInfo();
                break;
            case "Save":
                try {
                    Repository.getR().setAll();
                    LoadOrSave.saveObjects(Repository.getR().getShapes(), Repository.getR().getLines(), Repository.getR().getFilePath());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Load":
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Load Diagram");
                int userSelect = fileChooser.showOpenDialog(this);
                if (userSelect == JFileChooser.APPROVE_OPTION) {
                    try {
                        Object[] objects = LoadOrSave.loadObjects(Repository.getR().getFilePath());
                        Stack<Shape> loadedShapes = (Stack<Shape>) objects[0];
                        Stack<Line> loadedLines = (Stack<Line>) objects[1];
                        Repository.getR().setLoadShapes(loadedShapes);
                        Repository.getR().setLoadLines(loadedLines);
                    } catch (IOException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                break;
            case "Results":
                ProgressArea progressArea = new ProgressArea();
                JFrame progressFrame = new JFrame("Progress");
                progressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                progressFrame.getContentPane().add(progressArea);
                progressFrame.pack();
                progressFrame.setVisible(true);
                break;

        }
    }

    /**
     * This method is called whenever mouse is clicked. When a mouse is clicked, it draws the shape according to
     * Selected shape from menu. When a mouse is clicked twice on two different shapes, it draws line between those
     * Shapes.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        boolean exist = false;
        x1 = e.getX() - WIDTH / 2;
        y1 = e.getY() - HEIGHT / 2;
        Point p = new Point(e.getX(), e.getY());
        shape = Repository.getR().getShape();

        if (e.getClickCount() == 1) {
            pointExistInShape(p);

            if (!exist && !shape.isEmpty()) {
                if (shape.equals("Begin")) {
                    Repository.getR().addShape(new Circle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                } else if (shape.equals("End")) {
                    Shape circle = new Circle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                    Shape filledCircle = new FillDecorator(circle, x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                    Repository.getR().addShape(filledCircle);
                } else if (shape.equals("Call a method")) {
                    Shape rectangle = new Rectangle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                    Shape callMethod = new CallDecorator(rectangle, x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                    Repository.getR().addShape(callMethod);
                } else if (shape.equals("Instruction")) {
                    Repository.getR().addShape(new Rectangle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                } else if (shape.equals("Input or Output")) {
                    Repository.getR().addShape(new Parallelogram(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                } else if (shape.equals("Variable Declaration")) {
                    Shape rectangle = new Rectangle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                    Shape variableRect = new VariableDecorate(rectangle, x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                    Repository.getR().addShape(variableRect);
                } else if (shape.equals("Condition")) {
                    Repository.getR().addShape(new Diamond(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                }
                repaint();

            }

            noTextEntriesShape(p);
        }

        for (Shape sp : Repository.getR().getShapes()) {
            pointExistInShape(e, p, sp);
        }
        repaint();
    }

    private void noTextEntriesShape(Point p) {
        if (!shape.equals("Begin") && !shape.equals("End")) {
            for (Shape sp : Repository.getR().getShapes()) {
                if (sp.contains(p) && !sp.isTextDefined() && !exist) {
                    JFrame frame = new JFrame();
                    String result = JOptionPane.showInputDialog(frame, "Enter expression:");
                    sp.setText(result);
                    repaint();
                    sp.setTextDefined(true);
                }
                sp.setTextDefined(false);
            }
        }
    }

    private void pointExistInShape(Point p) {
        for (Shape sh : Repository.getR().getShapes()) {
            if (sh.contains(p)) {
                exist = true;
                break;
            }
        }
    }

    private void moreThanTwoShapes() {
        if (Repository.getR().getC().size() > 2) {
            Shape shape = Repository.getR().getC().pop();
            Repository.getR().clearC();
            Repository.getR().getC().push(shape);
        }
    }

    private void setLineFlags(Line line) {
        if (count % 2 == 1) {
            line.setFlag(true);
        } else {
            line.setFlag(false);
        }
        count++;
    }

    private void lineMessages(Line line) {
        if (Repository.getR().getC().get(0).toString().contains("Diamond")) {
            line.lineMessage(true);
            System.out.println("true");

        } else {
            line.lineMessage(false);
            System.out.println("false");
        }
    }

    private void something() {
        if (Repository.getR().getC().size() == 2) {
            Line line = new Line(Repository.getR().getC().get(0), Repository.getR().getC().get(1));
            Repository.getR().addLine(line);
            Repository.getR().setLine(line);

            //setting line flags
            setLineFlags(line);

            //line messages
            lineMessages(line);

        }
    }

    private void pointExistInShape(MouseEvent e, Point p, Shape sp) {
        if (e.getClickCount() == 2 && sp.contains(p)) {
            Repository.getR().addC(sp);

            //removing if more than two shapes
            moreThanTwoShapes();

            //Something
            something();
        }
    }

    /**
     * This method is called whenever mouse is pressed. This is checking if the mouse pressed inside the shape or not.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        for (Shape shape : Repository.getR().getShapes()) {
            if (shape.contains(p)) {
                shape.setFlag(true);
                prevPoint = e.getPoint();
            }
        }
    }

    /**
     * This method is called whenever the mouse is released.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        for (Shape shape : Repository.getR().getShapes()) {
            shape.setFlag(false);
        }
    }

    /**
     * This method is called whenever the mouse enters.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * This method is called whenever the mouse exits.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * This method is called whenever the mouse is dragged. This method allows the detects if the click is inside the
     * Shape or not, and allows to move/drag the shape around with mouse.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        for (Shape shape : Repository.getR().getShapes()) {
            if (shape.getFlag()) {
                int deltaX = e.getX() - prevPoint.x;
                int deltaY = e.getY() - prevPoint.y;
                shape.setLocation(shape.getX() + deltaX, shape.getY() + deltaY, shape.WIDTH, shape.HEIGHT);
                if (shape instanceof FillDecorator) {
                    ((FillDecorator) shape).setLocation(shape.getX(), shape.getY(), shape.WIDTH, shape.HEIGHT);
                } else if (shape instanceof ShapeDecorator) {
                    ((ShapeDecorator) shape).setLocation(shape.getX(), shape.getY(), shape.WIDTH, shape.HEIGHT);
                }
            }
        }
        prevPoint = e.getPoint();
        repaint();
    }


    /**
     * This method is called whenever the mouse is moved.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * This method undoes the line and shapes that are drawn on the panel.
     */
    void undo() {
        if (!Repository.getR().getLines().isEmpty() || !Repository.getR().getShapes().isEmpty()) {
            if (!Repository.getR().getLines().isEmpty()) {
                Repository.getR().getLines().pop();
            }
            Repository.getR().getShapes().pop();
        }
        repaint();
    }

    /**
     * This method clears the lines and shapes that are drawn panel.
     */
    void clear() {
        if (!Repository.getR().getLines().isEmpty() || !Repository.getR().getShapes().isEmpty()) {
            if (!Repository.getR().getLines().isEmpty()) {
                Repository.getR().getLines().clear();
            }
            Repository.getR().getShapes().clear();
        }
        repaint();
    }
}
