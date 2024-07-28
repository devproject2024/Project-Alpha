package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Arrays;

public class CJRSelectCitiesModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRSelectCityModel> mCityList = new ArrayList<>();

    public ArrayList<CJRSelectCityModel> getCities() {
        return this.mCityList;
    }

    public void setCities(ArrayList<CJRSelectCityModel> arrayList) {
        this.mCityList = arrayList;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRSelectCitiesModel cJRSelectCitiesModel = new CJRSelectCitiesModel();
        CJRSelectCityModel[] cJRSelectCityModelArr = (CJRSelectCityModel[]) fVar.a(str, CJRSelectCityModel[].class);
        if (cJRSelectCityModelArr != null) {
            cJRSelectCitiesModel.setCities(new ArrayList(Arrays.asList(cJRSelectCityModelArr)));
        }
        return cJRSelectCitiesModel;
    }
}
