package com.travel.travels.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class ReferViewEarningBody extends IJRPaytmDataModel {
    @b(a = "content_body")
    private String contentBody;
    @b(a = "content_header")
    private String contentHeader;
    @b(a = "cb_earned_current_month")
    private int curremtMomthCBEarned;
    @b(a = "max_monthly_limit")
    private int maxCbMonthlyLimit;
    @b(a = "results")
    private ArrayList<ReferResultItem> resultItem;
    @b(a = "total_cb_earned")
    private int totalCashBackEarned;

    public int getTotalCashBackEarned() {
        return this.totalCashBackEarned;
    }

    public void setTotalCashBackEarned(int i2) {
        this.totalCashBackEarned = i2;
    }

    public int getCurremtMomthCBEarned() {
        return this.curremtMomthCBEarned;
    }

    public void setCurremtMomthCBEarned(int i2) {
        this.curremtMomthCBEarned = i2;
    }

    public int getMaxCbMonthlyLimit() {
        return this.maxCbMonthlyLimit;
    }

    public void setMaxCbMonthlyLimit(int i2) {
        this.maxCbMonthlyLimit = i2;
    }

    public String getContentHeader() {
        return this.contentHeader;
    }

    public void setContentHeader(String str) {
        this.contentHeader = str;
    }

    public String getContentBody() {
        return this.contentBody;
    }

    public void setContentBody(String str) {
        this.contentBody = str;
    }

    public ArrayList<ReferResultItem> getResultItem() {
        return this.resultItem;
    }

    public void setResultItem(ArrayList<ReferResultItem> arrayList) {
        this.resultItem = arrayList;
    }
}
