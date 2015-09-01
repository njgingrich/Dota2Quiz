package ngingrich.dota2quiz.model.heroes;

/**
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeroAttribs {

    @Expose
    private HeroStr str;
    @SerializedName("int")
    @Expose
    private HeroInt _int;
    @Expose
    private HeroAgi agi;
    @Expose
    private int ms;
    @Expose
    private HeroDmg dmg;
    @Expose
    private double armor;

    /**
     *
     * @return
     * The str
     */
    public HeroStr getStr() {
        return str;
    }

    /**
     *
     * @param str
     * The str
     */
    public void setStr(HeroStr str) {
        this.str = str;
    }

    /**
     *
     * @return
     * The _int
     */
    public HeroInt getInt() {
        return _int;
    }

    /**
     *
     * @param _int
     * The int
     */
    public void setInt(HeroInt _int) {
        this._int = _int;
    }

    /**
     *
     * @return
     * The agi
     */
    public HeroAgi getAgi() {
        return agi;
    }

    /**
     *
     * @param agi
     * The agi
     */
    public void setAgi(HeroAgi agi) {
        this.agi = agi;
    }

    /**
     *
     * @return
     * The ms
     */
    public int getMs() {
        return ms;
    }

    /**
     *
     * @param ms
     * The ms
     */
    public void setMs(int ms) {
        this.ms = ms;
    }

    /**
     *
     * @return
     * The dmg
     */
    public HeroDmg getDmg() {
        return dmg;
    }

    /**
     *
     * @param dmg
     * The dmg
     */
    public void setDmg(HeroDmg dmg) {
        this.dmg = dmg;
    }

    /**
     *
     * @return
     * The armor
     */
    public double getArmor() {
        return armor;
    }

    /**
     *
     * @param armor
     * The armor
     */
    public void setArmor(double armor) {
        this.armor = armor;
    }

}
