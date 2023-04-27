import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    /**
     * Method below is inherited from ActionListener. It gets inputs from checkboxes which user operates With.
     * It sets to different operations using getActionCommand().
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Begin")) {
            Repository.getR().setShape("Begin");
        } else if (action.equals("End")) {
            Repository.getR().setShape("End");
        } else if (action.equals("Call a method")) {
            Repository.getR().setShape("Call a method");
        } else if (action.equals("Instruction")) {
            Repository.getR().setShape("Instruction");
        } else if (action.equals("Input or Output")) {
            Repository.getR().setShape("Input or Output");
        } else if (action.equals("Variable Declaration")) {
            Repository.getR().setShape("Variable Declaration");
        } else if (action.equals("Condition")) {
            Repository.getR().setShape("Condition");
        } else if (action.equals("Undo")) {
            undo();
        } else if (action.equals("Clear")) {
            clear();
        } else if (action.equals("About")) {
            JPanel panel = new JPanel(new BorderLayout());
            ImageIcon imageIcon = new ImageIcon("src/images/poly2.png");
            JLabel label = new JLabel(imageIcon);
            panel.add(label, BorderLayout.CENTER);
            JLabel description = new JLabel("Anthony Colin, Shiv Panchal, Luke Fanguna, Nathan Choi, Reza Mousakhani, Luke Franks");
            description.setFont(description.getFont().deriveFont(Font.BOLD));
            panel.add(description, BorderLayout.SOUTH);
            panel.setPreferredSize(new Dimension(600, 300));
            panel.setMaximumSize(new Dimension(600, 300));
            JOptionPane.showMessageDialog(null, panel, "Team Information", JOptionPane.PLAIN_MESSAGE);
        } else if (action.equals("Save")){
            try {
                Repository.getR().setAll();
                LoadOrSave.saveObjects(Repository.getR().getShapes(), Repository.getR().getLines(), Repository.getR().getFilePath());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (action.equals("Load")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Load Diagram");
            int userSelect = fileChooser.showOpenDialog(this);
            if (userSelect == JFileChooser.APPROVE_OPTION){
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

        if (e.getClickCount() == 1) {
            for (Shape sh : Repository.getR().getShapes()) {
                if (sh.contains(p)) {
                    exist = true;
                    break;
                }
            }

            String shape = Repository.getR().getShape();
            if (!exist) {
                if (!shape.isEmpty()) {
                    if (shape.equals("Begin")) {
                        Repository.getR().addShape(new Circle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                    } else if (shape.equals("End")) {
                        FillDecorator decoratedCircle = new FillDecorator(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                        Repository.getR().addShape(decoratedCircle);
                    } else if (shape.equals("Call a method")) {
                        CallDecorator decoratedCall = new CallDecorator(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                        Repository.getR().addShape(decoratedCall);
                    } else if (shape.equals("Instruction")) {
                        Repository.getR().addShape(new Rectangle(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                    } else if (shape.equals("Input or Output")) {
                        Repository.getR().addShape(new Parallelogram(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                    } else if (shape.equals("Variable Declaration")) {
                        VariableDecorate decoratedRect = new VariableDecorate(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color);
                        Repository.getR().addShape(decoratedRect);
                    } else if (shape.equals("Condition")) {
                        Repository.getR().addShape(new Diamond(x1 - 50, y1 - 50, x1 + 100, y1 + 100, color));
                    }
                    repaint();
                }
            }

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

        for (Shape sp : Repository.getR().getShapes()) {
            if (e.getClickCount() == 2) {
                if (sp.contains(p)) {
                    if (e.getClickCount() == 2) {
                        Repository.getR().addC(sp);
                    }

                    if (Repository.getR().getC().size() > 2) {
                        Shape shape = Repository.getR().getC().pop();
                        Repository.getR().clearC();
                        Repository.getR().getC().push(shape);
                    }

                    System.out.println(Repository.getR().getC());
                    if (Repository.getR().getC().size() == 2) {
                        Line line = new Line(Repository.getR().getC().get(0), Repository.getR().getC().get(1));
                        Repository.getR().addLine(line);
                        Repository.getR().setLine(line);

                        if (count % 2 == 1) {
                            line.setFlag(true);
                        } else {
                            line.setFlag(false);
                        }
                        count++;

                        if (Repository.getR().getC().get(0).toString().contains("Diamond")) {
                            line.lineMessage(true);
                            System.out.println("true");

                        } else {
                            line.lineMessage(false);
                            System.out.println("false");
                        }
                    }
                }
            }
        }
        repaint();
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

        Shape cond = null;

        for (Shape shape : Repository.getR().getShapes()) {

            if (shape.getFlag()) {
                cond = shape;
                int deltaX = e.getX() - prevPoint.x;
                int deltaY = e.getY() - prevPoint.y;
                shape.setLocation(shape.getX() + deltaX, shape.getY() + deltaY, shape.WIDTH, shape.HEIGHT);
                prevPoint = e.getPoint();
                repaint();
            }
        }
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
