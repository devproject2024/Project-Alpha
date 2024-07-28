package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightOperatorList implements IJRDataModel {
    @b(a = "oneway")
    private ArrayList<CJRFlightOperators> oneway;
    @b(a = "twoway")
    private ArrayList<CJRFlightOperators> twoway;

    public ArrayList<CJRFlightOperators> getTwowayOperators() {
        return this.twoway;
    }

    public void setTwoway(ArrayList<CJRFlightOperators> arrayList) {
        this.twoway = arrayList;
    }

    public ArrayList<CJRFlightOperators> getOnewayOperators() {
        return this.oneway;
    }

    public void setOneway(ArrayList<CJRFlightOperators> arrayList) {
        this.oneway = arrayList;
    }

    public String toString() {
        return "CJRFlightOperatorList [twoway = " + this.twoway + ", oneway = " + this.oneway + "]";
    }
}
