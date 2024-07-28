package net.one97.paytm.common.entity.amPark;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkCitiesModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRAmParkCityModel> mCityList = new ArrayList<>();

    public ArrayList<CJRAmParkCityModel> getCities() {
        return this.mCityList;
    }

    public void setCities(ArrayList<CJRAmParkCityModel> arrayList) {
        this.mCityList = arrayList;
    }
}
