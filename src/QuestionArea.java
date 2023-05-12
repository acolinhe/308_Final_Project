import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuestionArea extends JPanel {
    private JTextArea questionTextArea;
    private JTextArea answerTextArea1;
    private JTextArea answerTextArea2;
    private JTextArea answerTextArea3;
    private JTextArea answerTextArea4;
    private JComboBox<String> questionSelector;
    private String[] questions = {"Select Question", "Question 1", "Question 2", "Question 3", "Question 4"};
    public QuestionArea() {
        Controller controller = new Controller();
        setLayout(new BorderLayout());

        // Initialize your JComboBox here
        questionSelector = new JComboBox<>(questions);
        questionSelector.addActionListener(controller);

        add(questionSelector, BorderLayout.NORTH);

        JPanel questionAnswerPanel = new JPanel(new GridLayout(2, 1));

        questionTextArea = new JTextArea(5, 30);
        questionTextArea.setBorder(BorderFactory.createTitledBorder("Question"));
        questionAnswerPanel.add(questionTextArea);

        JPanel answerSubsectionsPanel = new JPanel(new GridLayout(2, 2));
        answerTextArea1 = new JTextArea(3, 30);
        answerTextArea1.setBorder(BorderFactory.createTitledBorder("Answer Subsection 1"));
        answerTextArea2 = new JTextArea(3, 30);
        answerTextArea2.setBorder(BorderFactory.createTitledBorder("Answer Subsection 2"));
        answerTextArea3 = new JTextArea(3, 30);
        answerTextArea3.setBorder(BorderFactory.createTitledBorder("Answer Subsection 3"));
        answerTextArea4 = new JTextArea(3, 30);
        answerTextArea4.setBorder(BorderFactory.createTitledBorder("Answer Subsection 4"));
        answerSubsectionsPanel.add(answerTextArea1);
        answerSubsectionsPanel.add(answerTextArea2);
        answerSubsectionsPanel.add(answerTextArea3);
        answerSubsectionsPanel.add(answerTextArea4);

        questionAnswerPanel.add(answerSubsectionsPanel);

        add(questionAnswerPanel, BorderLayout.CENTER);
    }

    public void updateQuestionText(String text){
        questionTextArea.setText(text);
    }
}
