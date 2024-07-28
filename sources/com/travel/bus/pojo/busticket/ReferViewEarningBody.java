package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class ReferViewEarningBody extends IJRPaytmDataModel {
    @b(a = "content_body")
    private String contentBody;
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

    public int getCurremtMomthCBEarned() {
        return this.curremtMomthCBEarned;
    }

    public int getMaxCbMonthlyLimit() {
        return this.maxCbMonthlyLimit;
    }

    public String getContentBody() {
        return this.contentBody;
    }

    public ArrayList<ReferResultItem> getResultItem() {
        return this.resultItem;
    }
}
