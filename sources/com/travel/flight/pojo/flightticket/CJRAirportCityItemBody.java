package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRAirportCityItemBody extends IJRPaytmDataModel {
    @b(a = "airports")
    private ArrayList<b> mAirportCityItems;
    @b(a = "routes")
    private ArrayList<CJRAirportCityLinguisticItem> mAirportRouteItems;

    public ArrayList<b> getmAirportCityItems() {
        return this.mAirportCityItems;
    }

    public void setmAirportCityItems(ArrayList<b> arrayList) {
        this.mAirportCityItems = arrayList;
    }

    public ArrayList<CJRAirportCityLinguisticItem> getmAirportRouteItems() {
        return this.mAirportRouteItems;
    }

    public void setmAirportRouteItems(ArrayList<CJRAirportCityLinguisticItem> arrayList) {
        this.mAirportRouteItems = arrayList;
    }
}
