import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import org.json.*;

public class OpenAI extends JPanel implements ActionListener {

    private JTextPane outputArea = new JTextPane();
    private JTextField inputField = new JTextField();

    /**
     * Constructor
     */
    public OpenAI() {
        setLayout(new BorderLayout());
        // output part
        outputArea.setEditable(false);
        outputArea.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // input part
        inputField.addActionListener(this);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        // add to frame
        add(inputField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
    }

    /**
     * Action listener for the input field and the send button
     *
     * @param e The event identifier
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String output = "Sorry, something went wrong!";
        try {
            output = getChatGPTResponse(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        StyledDocument doc = outputArea.getStyledDocument();
        Style styleRed = outputArea.addStyle("Red", null);
        StyleConstants.setForeground(styleRed, Color.RED);
        Style styleBlue = outputArea.addStyle("Blue", null);
        StyleConstants.setForeground(styleBlue, Color.BLUE);
        try {
            doc.insertString(doc.getLength(), "You: " + input + "\n", styleRed);
            doc.insertString(doc.getLength(), "ChatGPT: " + output + "\n", styleBlue);

        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
        inputField.setText("");
    }

    /**
     * Gets the response from ChatGPT
     *
     * @param input the question to send
     * @return answer from ChatGPT
     */
    private String getChatGPTResponse(String input) throws Exception {

        // Set environment variables in IntelliJ
        final String OPENAI_API_KEY = System.getenv("OPENAI_API_KEY");

        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + OPENAI_API_KEY);

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", input);
        data.put("max_tokens", 4000);

        conn.setDoOutput(true);
        conn.getOutputStream().write(data.toString().getBytes());

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = "";
        String line;
        while ((line = reader.readLine()) != null) {
            response += line;
        }
        reader.close();

        JSONObject responseJson = new JSONObject(response);
        JSONArray choices = responseJson.getJSONArray("choices");
        String text = choices.getJSONObject(0).getString("text");
        return text.trim();
    }

    /**
     * Main method for testing
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        JFrame test = new JFrame("ChatGPT Swing App");
        test.setLayout(new GridLayout(1,1));
        test.add(new OpenAI());
        test.setSize(400, 400);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


