package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TripBusDetailsStatus extends IJRPaytmDataModel {
    @a
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
