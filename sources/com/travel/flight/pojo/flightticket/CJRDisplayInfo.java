package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDisplayInfo implements IJRDataModel {
    @b(a = "o")
    private CJRFilterAndBannerOrder onwardInfo;
    @b(a = "r")
    private CJRFilterAndBannerOrder returnInfo;

    public CJRFilterAndBannerOrder getOnwardInfo() {
        return this.onwardInfo;
    }

    public void setOnwardInfo(CJRFilterAndBannerOrder cJRFilterAndBannerOrder) {
        this.onwardInfo = cJRFilterAndBannerOrder;
    }

    public CJRFilterAndBannerOrder getReturnInfo() {
        return this.returnInfo;
    }

    public void setReturnInfo(CJRFilterAndBannerOrder cJRFilterAndBannerOrder) {
        this.returnInfo = cJRFilterAndBannerOrder;
    }
}
