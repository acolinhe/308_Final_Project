import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Controller extends JPanel implements ActionListener, MouseListener, MouseMotionListener, ItemListener {
    Repository repo = Repository.getR();
    Color color = Color.BLACK;
    private int x1, y1, x2, y2;
    private boolean drawing;
    int preX1, preY1, preX2, preY2;
    private boolean isTextDefined = false;
    private boolean pressOut = false;

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
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        Point p = new Point(e.getX(), e.getY());
//
//        for(int i= 0; i < Repository.getR().getShapeSize(); i++){
//            Shape s = Repository.getR().getElement(i);
//
//            if(s.contains(p) && !isTextDefined){
//                JFrame frame = new JFrame();
//                Object result = JOptionPane.showInputDialog(frame, "Enter expression:");
//                repaint();
//                isTextDefined = true;
//            }
//        }
//        isTextDefined = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.drawing = true;
        x1 = e.getX();
        y1 = e.getY();

//        Shape sh;
//        Point p = new Point(e.getX(), e.getY());
//
//        for(int i =0; i < Repository.getR().getShapeSize(); i++) {
//            sh = Repository.getR().getElement(i);
//            preX1 = (int) (Repository.getR().getElement(i).x1 - e.getX());
//            preY1 = (int) (Repository.getR().getElement(i).y1 - e.getY());
//            preX2 = (int) (Repository.getR().getElement(i).x2 - e.getX());
//            preY2 = (int) (Repository.getR().getElement(i).y2 - e.getY());
//
//
//            if (sh.contains(p)) {
//                sh.move(preX1 + e.getY(), preY1 + e.getY(), preX2 + e.getX(), preY2 + e.getY());
//                repaint();
//            } else {
//                pressOut = true;
//            }
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.drawing = false;
        x2 = e.getX();
        y2 = e.getY();
        String shape = Repository.getR().getShape();
        //System.out.println(" 1:"+x1+" 2:"+y1+" 3:"+x2+" 4:"+y2);
        System.out.println("This is the shape: " + shape);
        if (!shape.isEmpty()) {

            if (shape.equals("Begin")) {
                Repository.getR().addShape(new Circle(x1, y1, x2, y2, color));
            }else if(shape.equals("End")){
                Repository.getR().addShape(new Circle(x1,y1,x2,y2,color));
            }else if(shape.equals("Call a method")){
                Repository.getR().addShape(new Rectangle(x1,y1,x2,y2,color));
            }else if(shape.equals("Instruction")){
                Repository.getR().addShape(new Rectangle(x1,y1,x2,y2,color));
            }else if(shape.equals("Input or Output")){
                Repository.getR().addShape(new Parallelogram(x1,y1,x2,y2,color));
            }else if(shape.equals("Variable Declaration")){
                Repository.getR().addShape(new Rectangle(x1,y1,x2,y2,color));
            }else if(shape.equals("Condition")) {
                Repository.getR().addShape(new Diamond(x1, y1, x2, y2, color));
            }
            repaint();
        }


//        Point p = new Point(e.getX(), e.getY());
//        for(int i = 0; i < Repository.getR().getShapeSize(); i++){
//            if(Repository.getR().getElement(i).contains(p)){
//                Repository.getR().getElement(i).move(preX1 + e.getX(), preY1 + e.getY(), preX2 + e.getX(), preY2 + e.getY());
//                repaint();
//            }else{
//                pressOut = false;
//            }
//        }

        System.out.println(Repository.getR().getShapeSize());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        for(int i =0; i < Repository.getR().getShapeSize(); i++){
//            if(!pressOut){
//                Repository.getR().getElement(i).move(preX1 + e.getX(), preY1+ e.getY(), preX2 + e.getX(), preY2 + e.getY());
//            }
//            repaint();
//        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
