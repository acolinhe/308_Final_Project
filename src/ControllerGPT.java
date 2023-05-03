import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class ControllerGPT implements ActionListener {
    private ChatGPT gpt = new ChatGPT();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Send")){
            String input = ChatArea.messageTextField.getText();
            System.out.println(input);

            String output = "Sorry, something went wrong!";
            try {
                output = gpt.getChatGPTResponse(input);
                System.out.println(output);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            StyledDocument doc = ChatArea.chatTextArea.getStyledDocument();
            Style styleGreen = ChatArea.chatTextArea.addStyle("LightGreen", null);
            StyleConstants.setForeground(styleGreen, Color.decode("#76D7C4"));
            Style styleLightGreen = ChatArea.chatTextArea.addStyle("Green", null);
            StyleConstants.setForeground(styleLightGreen, Color.decode("#D1F2EB"));


            try {
                doc.insertString(doc.getLength(), "You: " + input + "\n", styleGreen);
                doc.insertString(doc.getLength(), "ChatGPT: " + output + "\n", styleLightGreen);


            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
            ChatArea.messageTextField.setText("");
        }
    }

}
