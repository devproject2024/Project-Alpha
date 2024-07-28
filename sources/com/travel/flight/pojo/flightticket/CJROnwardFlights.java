package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROnwardFlights implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "flights")
    private ArrayList<CJRFlightDetailsItem> mFlightDetails;
    @b(a = "meta")
    private CJRFlightFilterMinMaxDetails mMeta;
    @b(a = "flight")
    private CJRFlightDetailsItem mRepriceFlight;
    @b(a = "provider")
    private String mRepriceProvider;

    public String getmRepriceProvider() {
        return this.mRepriceProvider;
    }

    public ArrayList<CJRFlightDetailsItem> getmFlightDetails() {
        return this.mFlightDetails;
    }

    public void setmFlightDetails(ArrayList<CJRFlightDetailsItem> arrayList) {
        this.mFlightDetails = arrayList;
    }

    public CJRFlightDetailsItem getmRepriceFlight() {
        return this.mRepriceFlight;
    }

    public CJRFlightFilterMinMaxDetails getmMeta() {
        return this.mMeta;
    }
}
