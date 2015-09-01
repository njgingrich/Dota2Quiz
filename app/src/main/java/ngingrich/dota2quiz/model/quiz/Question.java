package ngingrich.dota2quiz.model.quiz;

import java.util.HashSet;

/**
 * Created by nathan on 8/2/15.
 */
public class Question {
    private String question;
    private HashSet<Answer> answers;
    private Difficulty difficulty;
    private QuestionType type;
    private String image;


    public Question(String question, Difficulty difficulty, QuestionType type) {
        this.question = question;
        this.difficulty = difficulty;
        this.type = type;
    }

    public Question(String question, HashSet<Answer> answers, Difficulty difficulty,
                    QuestionType type) {
        this.question = question;
        this.answers = answers;
        this.difficulty = difficulty;
        this.type = type;
    }

    public Question(String question, HashSet<Answer> answers, Difficulty difficulty,
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
}
