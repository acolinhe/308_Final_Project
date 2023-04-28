import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class ChatArea extends JPanel {
    private JTextArea chatTextArea;
    private JTextField messageTextField;
    
    public ChatArea() {
        setLayout(new BorderLayout());
        
        // Create a panel for the chat window
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.PAGE_AXIS));
        
        // Create a scroll pane for the chat window
        JScrollPane chatScrollPane = new JScrollPane(chatPanel);
        chatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        chatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatScrollPane.setPreferredSize(new Dimension(400, 400));
        
        // Create a text area for the chat messages
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setLineWrap(true);
        chatTextArea.setWrapStyleWord(true);
        chatPanel.add(chatTextArea);
        
        add(chatScrollPane, BorderLayout.CENTER);
        
        // Create a panel for the message input and send button
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10, 10, 10, 10), 
                BorderFactory.createLineBorder(Color.GRAY)));
        
        // Create a text field for the message input
        messageTextField = new JTextField();
        messageTextField.setPreferredSize(new Dimension(350, 30));
        messagePanel.add(messageTextField, BorderLayout.CENTER);
        
        // Create a send button for sending the message
        JButton sendButton = new JButton("Send");
        messagePanel.add(sendButton, BorderLayout.EAST);
        
        add(messagePanel, BorderLayout.SOUTH);
        JLabel helpLabel = new JLabel("Need Help? Ask Professor GPT!");
        helpLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(helpLabel, BorderLayout.NORTH);
    }
}
