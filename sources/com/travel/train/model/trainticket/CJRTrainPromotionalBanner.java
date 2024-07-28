package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromotionalBanner extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "deeplink")
    private boolean deeplink;
    @b(a = "position")
    private String position;
    @b(a = "redirect_url")
    private String redirectUrl;
    @b(a = "url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public boolean getDeeplink() {
        return this.deeplink;
    }

    public String getPosition() {
        return this.position;
    }
}
