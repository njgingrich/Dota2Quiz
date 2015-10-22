package ngingrich.dota2quiz.model.abilities;

/**
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Abilities {

    @Expose
    private List<AbilityDatum> abilitydata = new ArrayList<>();
    private Random rand = new Random();

    /**
     *
     * @return
     * The abilitydata
     */
    public List<AbilityDatum> getAbilitydata() {
        return abilitydata;
    }

    /**
     *
     * @param abilitydata
     * The abilitydata
     */
    public void setAbilitydata(List<AbilityDatum> abilitydata) {
        this.abilitydata = abilitydata;
    }

    @Override
    public String toString() {
        return "Abilities{" +
                "abilitydata=" + abilitydata +
                '}';
    }

    public AbilityDatum getRandomDatum() {
        return abilitydata.get(rand.nextInt(abilitydata.size()));
    }
}