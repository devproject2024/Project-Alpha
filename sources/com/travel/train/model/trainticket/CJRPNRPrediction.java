package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPNRPrediction extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "color")
    private String color;
    @b(a = "value")
    private int value;

    public int getValue() {
        return this.value;
    }

    public String getColor() {
        return this.color;
    }
}
