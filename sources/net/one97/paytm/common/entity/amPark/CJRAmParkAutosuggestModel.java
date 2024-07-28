package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkAutosuggestModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "featured_park")
    private ArrayList<CJRAmParkAutosuggestEventItem> featuredParkList = new ArrayList<>();
    @b(a = "theme_park")
    private ArrayList<CJRAmParkAutosuggestEventItem> themeParkList = new ArrayList<>();
    @b(a = "water_park")
    private ArrayList<CJRAmParkAutosuggestEventItem> waterParkList = new ArrayList<>();

    public ArrayList<CJRAmParkAutosuggestEventItem> getThemeParkList() {
        return this.themeParkList;
    }

    public void setThemeParkList(ArrayList<CJRAmParkAutosuggestEventItem> arrayList) {
        this.themeParkList = arrayList;
    }

    public ArrayList<CJRAmParkAutosuggestEventItem> getWaterParkList() {
        return this.waterParkList;
    }

    public void setWaterParkList(ArrayList<CJRAmParkAutosuggestEventItem> arrayList) {
        this.waterParkList = arrayList;
    }

    public ArrayList<CJRAmParkAutosuggestEventItem> getFeaturedParkList() {
        return this.featuredParkList;
    }

    public void setFeaturedParkList(ArrayList<CJRAmParkAutosuggestEventItem> arrayList) {
        this.featuredParkList = arrayList;
    }
}
