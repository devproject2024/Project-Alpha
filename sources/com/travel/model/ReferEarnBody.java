package com.travel.model;

import com.business.merchant_payments.utility.StringUtility;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Iterator;

public class ReferEarnBody extends IJRPaytmDataModel {
    @b(a = "categoryImageUrl")
    private String categoryImageUrl;
    @b(a = "deeplink")
    private String deepLink;
    @b(a = "heading")
    private String heading;
    @b(a = "mainImageUrl")
    private String mainImageUrl;
    @b(a = "referralHeading")
    private String referralHeading;
    @b(a = "referralText")
    private String referralText;
    @b(a = "shareImage")
    private String shareImageUrl;
    @b(a = "shareText")
    private ArrayList<String> shareText = null;
    @b(a = "tnc")
    private ArrayList<String> tnc = null;

    public String getShareText() {
        Iterator<String> it2 = this.shareText.iterator();
        String str = "";
        while (it2.hasNext()) {
            str = str + it2.next() + StringUtility.NEW_LINE;
        }
        return str;
    }

    public void setShareText(ArrayList<String> arrayList) {
        this.shareText = arrayList;
    }

    public String getCategoryImageUrl() {
        return this.categoryImageUrl;
    }

    public void setCategoryImageUrl(String str) {
        this.categoryImageUrl = str;
    }

    public String getReferralHeading() {
        return this.referralHeading;
    }

    public void setReferralHeading(String str) {
        this.referralHeading = str;
    }

    public String getMainImageUrl() {
        return this.mainImageUrl;
    }

    public void setMainImageUrl(String str) {
        this.mainImageUrl = str;
    }

    public String getReferralText() {
        return this.referralText;
    }

    public void setReferralText(String str) {
        this.referralText = str;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public ArrayList<String> getTnc() {
        return this.tnc;
    }

    public void setTnc(ArrayList<String> arrayList) {
        this.tnc = arrayList;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getShareImageUrl() {
        return this.shareImageUrl;
    }
}
