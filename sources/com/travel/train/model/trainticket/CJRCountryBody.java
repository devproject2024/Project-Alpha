package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCountryBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "countryList")
    private ArrayList<CJRCountrys> mCountryList;

    public ArrayList<CJRCountrys> getCountryList() {
        return this.mCountryList;
    }
}
