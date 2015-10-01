package ngingrich.dota2quiz.model.quiz;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nathan on 8/2/15.
 */
public class Question {
    private static final String TAG = Question.class.getSimpleName();
    private String question;
    private List<Answer> answers;
    private Difficulty difficulty;
    private QuestionType type;
    private String image;


    public Question(String question, Difficulty difficulty, QuestionType type) {
        this.question = question;
        this.answers = new ArrayList<>();
        this.difficulty = difficulty;
        this.type = type;
        this.image = "";
    }

    public Question(String question, ArrayList<Answer> answers, Difficulty difficulty,
                    QuestionType type) {
        this.question = question;
        this.answers = answers;
        this.difficulty = difficulty;
        this.type = type;
        this.image = "";
    }

    public Question(String question, ArrayList<Answer> answers, Difficulty difficulty,
                    QuestionType type, String image) {
        this.question = question;
        this.answers = answers;
        this.difficulty = difficulty;
        this.type = type;
        this.image = image;
    }

    public void addAnswer(Answer a) {
        answers.add(a);
    }

    public String getQuestion() {
        return question;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Answer getCorrectAnswer() {
        for (Answer a : answers) {
            if (a.isCorrect()) {
                return a;
            }
        }
        return null; // if this happens Java has failed me, or someone didn't insert a true
    }

    public QuestionType getType() {
        return type;
    }
}
