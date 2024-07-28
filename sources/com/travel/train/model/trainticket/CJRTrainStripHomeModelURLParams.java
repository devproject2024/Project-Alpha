package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainStripHomeModelURLParams extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "action")
    private String action;
    @b(a = "type")
    private String type;
    @b(a = "url")
    private String url;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUrl() {
        return this.url;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }
}
