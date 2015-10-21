package ngingrich.dota2quiz.model.abilities;

import com.google.gson.annotations.Expose;

/**
 * Created by nathan on 8/4/15.
 */
public class Cmb {

    @Expose
    private String type;
    @Expose
    private String value;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return type + ": " + value;
    }
}