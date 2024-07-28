package com.travel.flight.pojo.flightticket.paxinfo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRDynamicValidationAutoSuggest extends IJRPaytmDataModel {
    @b(a = "body")
    private ArrayList<a> body = null;

    public ArrayList<a> getBody() {
        return this.body;
    }
}
