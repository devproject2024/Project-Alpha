package net.one97.paytm.common.entity.movies.search;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLocationListArray extends IJRPaytmDataModel implements IJRDataModel {
    ArrayList<CJRLocation> mLocationList;

    public ArrayList<CJRLocation> getLocationList() {
        return this.mLocationList;
    }

    public void setLocationList(ArrayList<CJRLocation> arrayList) {
        this.mLocationList = arrayList;
    }
}
