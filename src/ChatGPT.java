import org.json.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPT {

    //Getting response from ChatGPT API
    public String getChatGPTResponse(String input) throws Exception {

        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer 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");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", input);
        data.put("max_tokens", 4000);

        conn.setDoOutput(true);
        conn.getOutputStream().write(data.toString().getBytes());

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject responseJson = new JSONObject(response.toString());
        JSONArray choices = responseJson.getJSONArray("choices");
        String text = choices.getJSONObject(0).getString("text");
        return text.trim();
    }
}
