package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFilterAndBannerInfoItem implements IJRDataModel {
    @b(a = "banner_url")
    private String mBannerUrl;
    private String mBannerUrlInfo;
    @b(a = "name")
    private String mFilterName;
    @b(a = "heading")
    private String mHeading;
    @b(a = "text")
    private String mText;
    @b(a = "type")
    private String mType;

    public void setmBannerUrl(String str) {
        this.mBannerUrl = str;
    }

    public String getmBannerUrl() {
        return this.mBannerUrl;
    }

    public void setmType(String str) {
        this.mType = str;
    }

    public String getmType() {
        return this.mType;
    }

    public String getmFilterName() {
        return this.mFilterName;
    }

    public String getmHeading() {
        return this.mHeading;
    }

    public String getmText() {
        return this.mText;
    }

    public String getmBannerUrlInfo() {
        return this.mBannerUrlInfo;
    }

    public void setmBannerUrlInfo(String str) {
        this.mBannerUrlInfo = str;
    }
}
