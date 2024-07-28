package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRBusMyTripData extends IJRPaytmDataModel {
    @b(a = "body")
    private ArrayList<CJRBusMyTripList> busMyTripLists;

    public ArrayList<CJRBusMyTripList> getBusMyTripLists() {
        return this.busMyTripLists;
    }

    public void setBusMyTripLists(ArrayList<CJRBusMyTripList> arrayList) {
        this.busMyTripLists = arrayList;
    }
}
