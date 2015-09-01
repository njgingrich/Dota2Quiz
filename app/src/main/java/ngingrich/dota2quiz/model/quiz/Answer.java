package ngingrich.dota2quiz.model.quiz;

/**
 * Created by nathan on 8/2/15.
 */
public class Answer {
    private boolean correct;
    private String text;
    private String image; // optional

    public Answer(String text) {
        this(false, text);
    }

    public Answer(String text, String image) {
        this(false, text, image);
    }

    public Answer(boolean correct, String text) {
        this.correct = correct;
        this.text = text;
    }

    public Answer(boolean correct, String text, String image) {
        this.correct = correct;
        this.text = text;
        this.image = image;
    }
}
