package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoInfoStatusAction extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "deeplink")
    private boolean deeplink;
    @b(a = "label")
    private String label;
    @b(a = "url")
    private String url;

    public String getLabel() {
        return this.label;
    }

    public String getUrl() {
        return this.url;
    }

    public Boolean getDeeplink() {
        return Boolean.valueOf(this.deeplink);
    }
}
