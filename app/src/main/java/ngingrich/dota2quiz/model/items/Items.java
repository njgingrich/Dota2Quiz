package ngingrich.dota2quiz.model.items;

/**
 * Created by nathan on 8/2/15.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Items {
    @Override
    public String toString() {
        return "Items{" +
                "itemdata=" + itemdata +
                '}';
    }

    @Expose
    private List<ItemDatum> itemdata = new ArrayList<ItemDatum>();

    /**
     *
     * @return
     * The itemdata
     */
    public List<ItemDatum> getItemdata() {
        return itemdata;
    }

    /**
     *
     * @param itemdata
     * The itemdata
     */
    public void setItemdata(List<ItemDatum> itemdata) {
        this.itemdata = itemdata;
    }

}
