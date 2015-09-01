package ngingrich.dota2quiz.model.abilities;

/**
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Affect {

    @Expose
    private String ability;
    @Expose
    private String affects;
    @SerializedName("damage_type")
    @Expose
    private String damageType;
    @SerializedName("pierces_immunity")
    @Expose
    private String piercesImmunity;

    /**
     *
     * @return
     * The ability
     */
    public String getAbility() {
        return ability;
    }

    /**
     *
     * @param ability
     * The ability
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }

    /**
     *
     * @return
     * The affects
     */
    public String getAffects() {
        return affects;
    }

    /**
     *
     * @param affects
     * The affects
     */
    public void setAffects(String affects) {
        this.affects = affects;
    }

    /**
     *
     * @return
     * The damageType
     */
    public String getDamageType() {
        return damageType;
    }

    /**
     *
     * @param damageType
     * The damage_type
     */
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    /**
     *
     * @return
     * The piercesImmunity
     */
    public String getPiercesImmunity() {
        return piercesImmunity;
    }

    /**
     *
     * @param piercesImmunity
     * The pierces_immunity
     */
    public void setPiercesImmunity(String piercesImmunity) {
        this.piercesImmunity = piercesImmunity;
    }

}