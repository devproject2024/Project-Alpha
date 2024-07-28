package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemBody implements IJRDataModel {
    @b(a = "dictionary")
    private CJRBusSearchItemDictionary dictionary;
    @b(a = "trips")
    private ArrayList<CJRBusSearchItem> trips;

    public ArrayList<CJRBusSearchItem> getTrips() {
        return this.trips;
    }

    public void setTrips(ArrayList<CJRBusSearchItem> arrayList) {
        this.trips = arrayList;
    }

    public CJRBusSearchItemDictionary getDictionary() {
        return this.dictionary;
    }

    public void setDictionary(CJRBusSearchItemDictionary cJRBusSearchItemDictionary) {
        this.dictionary = cJRBusSearchItemDictionary;
    }
}
