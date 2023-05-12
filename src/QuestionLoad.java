import org.json.*;
import java.nio.file.*;
import java.util.*;

public class QuestionLoad {
    private List<String> questions;
    private List<String> correctAnswers;

    public QuestionLoad(String questionFile, String answerFile){
        try {
            // Read the questions
            String content = new String(Files.readAllBytes(Paths.get(questionFile)));
            JSONObject questionsObject = new JSONObject(content);
            JSONArray questionsArray = questionsObject.getJSONArray("questions");

            questions = new ArrayList<>();
            for (int i = 0; i < questionsArray.length(); i++) {
                questions.add(questionsArray.getString(i));
            }

            // Read the answers
            content = new String(Files.readAllBytes(Paths.get(answerFile)));
            JSONObject answersObject = new JSONObject(content);
            JSONArray answersArray = answersObject.getJSONArray("answers");

            correctAnswers = new ArrayList<>();
            for (int i = 0; i < answersArray.length(); i++) {
                correctAnswers.add(answersArray.getString(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getQuestions() {
        return this.questions;
    }

    public List<String> getCorrectAnswers() {
        return this.correctAnswers;
    }
}
