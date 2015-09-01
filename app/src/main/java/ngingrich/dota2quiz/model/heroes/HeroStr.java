package ngingrich.dota2quiz.model.heroes;

/**
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;

public class HeroStr {

    @Expose
    private int b;
    @Expose
    private String g;

    /**
     *
     * @return
     * The b
     */
    public int getB() {
        return b;
    }

    /**
     *
     * @param b
     * The b
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     *
     * @return
     * The g
     */
    public String getG() {
        return g;
    }

    /**
     *
     * @param g
     * The g
     */
    public void setG(String g) {
        this.g = g;
    }

}
