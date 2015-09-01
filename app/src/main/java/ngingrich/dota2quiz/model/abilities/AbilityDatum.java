package ngingrich.dota2quiz.model.abilities;

/**
 * dname
 *      Display name
 * affects
 *      HTML noting target type, affected units, damage type.
 * desc
 * dmg
 *      HTML noting damage.
 * attrib
 *      HTML noting ability's attributes, e.g. radius, chances, stun duration.
 * cmb
 *      HTML noting cooldown and mana cost.
 * lore
 * hurl
 *      Hero URL, http://dota2.com/hero/_hurl_/
 *
 * Created by nathan on 8/2/15.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class AbilityDatum {
    @Expose
    private String aname;
    @Expose
    private String dname;
    @Expose
    private List<Affect> affects = new ArrayList<Affect>();
    @Expose
    private String desc;
    @Expose
    private String notes;
    @Expose
    private String dmg;
    @Expose
    private List<String> attrib = new ArrayList<String>();
    @Expose
    private List<Cmb> cmb = new ArrayList<Cmb>();
    @Expose
    private String lore;
    @Expose
    private String hurl;

    /**
     *
     * @return
     * The aname
     */
    public String getAname() {
        return aname;
    }

    /**
     *
     * @param aname
     * The aname
     */
    public void setAname(String aname) {
        this.aname = aname;
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
     * The affects
     */
    public List<Affect> getAffects() {
        return affects;
    }

    /**
     *
     * @param affects
     * The affects
     */
    public void setAffects(List<Affect> affects) {
        this.affects = affects;
    }

    /**
     *
     * @return
     * The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     * The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return
     * The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     * The dmg
     */
    public String getDmg() {
        return dmg;
    }

    /**
     *
     * @param dmg
     * The dmg
     */
    public void setDmg(String dmg) {
        this.dmg = dmg;
    }

    /**
     *
     * @return
     * The attrib
     */
    public List<String> getAttrib() {
        return attrib;
    }

    /**
     *
     * @param attrib
     * The attrib
     */
    public void setAttrib(List<String> attrib) {
        this.attrib = attrib;
    }

    /**
     *
     * @return
     * The cmb
     */
    public List<Cmb> getCmb() {
        return cmb;
    }

    /**
     *
     * @param cmb
     * The cmb
     */
    public void setCmb(List<Cmb> cmb) {
        this.cmb = cmb;
    }

    /**
     *
     * @return
     * The lore
     */
    public String getLore() {
        return lore;
    }

    /**
     *
     * @param lore
     * The lore
     */
    public void setLore(String lore) {
        this.lore = lore;
    }

    /**
     *
     * @return
     * The hurl
     */
    public String getHurl() {
        return hurl;
    }

    /**
     *
     * @param hurl
     * The hurl
     */
    public void setHurl(String hurl) {
        this.hurl = hurl;
    }

}
