package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCountryCodeBody implements IJRDataModel {
    @b(a = "countryList")
    private ArrayList<CJRCountryCode> mCountryList;

    public ArrayList<CJRCountryCode> getCountryList() {
        return this.mCountryList;
    }
}
