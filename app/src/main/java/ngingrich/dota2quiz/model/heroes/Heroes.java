package ngingrich.dota2quiz.model.heroes;

/**
 * Created by nathan on 8/2/15.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Heroes {

    @Override
    public String toString() {
        return "Heroes{" +
                "herodata=" + herodata +
                '}';
    }

    @Expose
    private List<HeroDatum> herodata = new ArrayList<HeroDatum>();

    /**
     *
     * @return
     * The herodata
     */
    public List<HeroDatum> getHerodata() {
        return herodata;
    }

    /**
     *
     * @param herodata
     * The herodata
     */
    public void setHerodata(List<HeroDatum> herodata) {
        this.herodata = herodata;
    }

}