package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCinemaV1 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cinemas")
    private ArrayList<CJRCinemas> cinemas;
    private ArrayList<CJRAmenity> cjrAmenities;

    public void setCjrAmenities(ArrayList<CJRAmenity> arrayList) {
        this.cjrAmenities = arrayList;
    }

    public ArrayList<CJRAmenity> getCjrAmenities() {
        return this.cjrAmenities;
    }

    public ArrayList<CJRCinemas> getCinemas() {
        return this.cinemas;
    }

    public void setCinemas(ArrayList<CJRCinemas> arrayList) {
        this.cinemas = arrayList;
    }
}
