package ngingrich.dota2quiz.model.items;

/**
 * id
 * img
 *      Filename of the item's image, relative to http://media.steampowered.com/apps/dota2/images/items/
 * dname
 *      Item's display name.
 * qual
 *      Token representing item quality? Observed tokens:
 *          artifact
 *          common
 *          component
 *          consumable
 *          epic
 *          rare
 *          secret_shop
 * cost
 *      Gold cost of the item.
 * desc
 *      Localized description.
 * attrib
 *      HTML representing the items attributes.
 * mc
 *      Mana cost
 * cd
 *      Cooldown
 * lore
 *      Localized item lore.
 * components
 *      List of tokens for items combine to create this item; returns list or null.
 * created
 *      Whether the item is created from components.
 *
 * Created by nathan on 8/2/15.
 */
import com.google.gson.annotations.Expose;

public class ItemDatum {

    @Expose
    private String iname;
    @Expose
    private int id;
    @Expose
    private String img;
    @Expose
    private String dname;
    @Expose
    private String qual;
    @Expose
    private int cost;
    @Expose
    private String desc;
    @Expose
    private String notes;
    @Expose
    private String attrib;
    @Expose
    private int mc;
    @Expose
    private int cd;
    @Expose
    private String lore;
    @Expose
    private Object components;
    @Expose
    private Boolean created;

    /**
     *
     * @return
     * The iname
     */
    public String getIname() {
        return iname;
    }

    /**
     *
     * @param iname
     * The iname
     */
    public void setIname(String iname) {
        this.iname = iname;
    }

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The img
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * @param img
     * The img
     */
    public void setImg(String img) {
        this.img = img;
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
     * The qual
     */
    public String getQual() {
        return qual;
    }

    /**
     *
     * @param qual
     * The qual
     */
    public void setQual(String qual) {
        this.qual = qual;
    }

    /**
     *
     * @return
     * The cost
     */
    public int getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     * The cost
     */
    public void setCost(int cost) {
        this.cost = cost;
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
     * The attrib
     */
    public String getAttrib() {
        return attrib;
    }

    /**
     *
     * @param attrib
     * The attrib
     */
    public void setAttrib(String attrib) {
        this.attrib = attrib;
    }

    /**
     *
     * @return
     * The mc
     */
    public int getMc() {
        return mc;
    }

    /**
     *
     * @param mc
     * The mc
     */
    public void setMc(int mc) {
        this.mc = mc;
    }

    /**
     *
     * @return
     * The cd
     */
    public int getCd() {
        return cd;
    }

    /**
     *
     * @param cd
     * The cd
     */
    public void setCd(int cd) {
        this.cd = cd;
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
     * The components
     */
    public Object getComponents() {
        return components;
    }

    /**
     *
     * @param components
     * The components
     */
    public void setComponents(Object components) {
        this.components = components;
    }

    /**
     *
     * @return
     * The created
     */
    public Boolean getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(Boolean created) {
        this.created = created;
    }

}
