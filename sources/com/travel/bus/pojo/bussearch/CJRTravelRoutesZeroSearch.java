package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRTravelRoutesZeroSearch extends IJRPaytmDataModel {
    @b(a = "dictionary")
    private HashMap<String, CJRDictionaryItem> dictionary;
    @b(a = "nearby")
    private CJRNearbyZeroSearch nearby;
    @b(a = "nhop")
    private CJRNhopZeroSearch nhop;

    public CJRNearbyZeroSearch getNearby() {
        return this.nearby;
    }

    public CJRNhopZeroSearch getNhop() {
        return this.nhop;
    }

    public HashMap<String, CJRDictionaryItem> getDictionary() {
        return this.dictionary;
    }
}
