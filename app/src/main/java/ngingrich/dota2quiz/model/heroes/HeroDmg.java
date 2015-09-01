package ngingrich.dota2quiz.model.heroes;

/**
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;

public class HeroDmg {

    @Expose
    private int min;
    @Expose
    private int max;

    /**
     *
     * @return
     * The min
     */
    public int getMin() {
        return min;
    }

    /**
     *
     * @param min
     * The min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     *
     * @return
     * The max
     */
    public int getMax() {
        return max;
    }

    /**
     *
     * @param max
     * The max
     */
    public void setMax(int max) {
        this.max = max;
    }

}
