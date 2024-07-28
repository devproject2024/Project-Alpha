package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderTextHolder extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "icon")
    private String icon;
    @b(a = "text")
    private String text;

    public String getIcon() {
        return this.icon;
    }

    public String getText() {
        return this.text;
    }
}
