package ngingrich.dota2quiz.model.heroes;

/**
 * dname
 *      Hero's display name.
 * u
 *      Hero token.
 * pa
 *      Primary attribute. Values:
 *          str:
 *          int:
 *          agi:
 * attribs
 *      str
 *          b
 *              Base.
 *          g
 *              Gain.
 *      int
 *          b
 *          g
 *      agi
 *          b
 *          g
 *      ms
 *          Move speed.
 *      dmg
 *          Starting damage.
 *          min
 *          max
 *      armor
 *          Starting armour.
 * dac
 *      Localized string for attack type, Melee or Ranged.
 * droles
 *      Display string for roles.
 *
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;

public class HeroDatum {

    @Expose
    private String hname;
    @Expose
    private String dname;
    @Expose
    private String u;
    @Expose
    private String pa;
    @Expose
    private HeroAttribs attribs;
    @Expose
    private String dac;
    @Expose
    private String droles;

    /**
     *
     * @return
     * The hname
     */
    public String getHname() {
        return hname;
    }

    /**
     *
     * @param hname
     * The hname
     */
    public void setHname(String hname) {
        this.hname = hname;
    }

    /**
     *
     * @return
     * The dname
     */
    public String getDname() {
        return dname;
    }

    /**
     *
     * @param dname
     * The dname
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     *
     * @return
     * The u
     */
    public String getU() {
        return u;
    }

    /**
     *
     * @param u
     * The u
     */
    public void setU(String u) {
        this.u = u;
    }

    /**
     *
     * @return
     * The pa
     */
    public String getPa() {
        return pa;
    }

    /**
     *
     * @param pa
     * The pa
     */
    public void setPa(String pa) {
        this.pa = pa;
    }

    /**
     *
     * @return
     * The attribs
     */
    public HeroAttribs getAttribs() {
        return attribs;
    }

    /**
     *
     * @param attribs
     * The attribs
     */
    public void setAttribs(HeroAttribs attribs) {
        this.attribs = attribs;
    }

    /**
     *
     * @return
     * The dac
     */
    public String getDac() {
        return dac;
    }

    /**
     *
     * @param dac
     * The dac
     */
    public void setDac(String dac) {
        this.dac = dac;
    }

    /**
     *
     * @return
     * The droles
     */
    public String getDroles() {
        return droles;
    }

    /**
     *
     * @param droles
     * The droles
     */
    public void setDroles(String droles) {
        this.droles = droles;
    }

}
