import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChatArea extends JPanel{

    public ChatArea() {
        setLayout(new BorderLayout());
        ControllerGPT cpt = new ControllerGPT();
        Repository repo = Repository.getR();
        
        // Create a panel for the chat window
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.PAGE_AXIS));
        
        // Create a text area for the chat messages

        repo.setChatTextArea();
        JTextPane chatTextArea = repo.getChatTextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setContentType("text/html");
        chatTextArea.setFont(new Font("Monospaced", Font.BOLD,14));
        chatTextArea.setBackground(Color.decode("#343541"));

        //Create a scroll pane for the chat window
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        scrollPane.add(chatPanel);
        add(scrollPane, BorderLayout.CENTER);
        
        // Create a panel for the message input and send button
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10, 10, 10, 10), 
                BorderFactory.createLineBorder(Color.GRAY)));
        
        // Create a text field for the message input
        repo.setMessageTextField();
        JTextField messageTextField = repo.getMessageTextField();
        messageTextField.setPreferredSize(new Dimension(350, 30));
        messagePanel.add(messageTextField, BorderLayout.CENTER);
        
        // Create a send button for sending the message
        JButton sendButton = new JButton("Send");
        messagePanel.add(sendButton, BorderLayout.EAST);
        sendButton.addActionListener(cpt);
        
        add(messagePanel, BorderLayout.SOUTH);
        JLabel helpLabel = new JLabel("Need Help? Ask Professor GPT!");
        helpLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(helpLabel, BorderLayout.NORTH);
    }
}
