package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBookingStatus extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "homepage")
    private ArrayList<CJRNotification> mHomeNotification;
    @b(a = "notification_status_homepage")
    private String mHomePageStatus;
    @b(a = "search")
    private ArrayList<CJRNotification> mSearchNotification;
    @b(a = "notification_status_search")
    private String mSearchPageStatus;

    public String getmHomePageStatus() {
        return this.mHomePageStatus;
    }

    public String getmSearchPageStatus() {
        return this.mSearchPageStatus;
    }

    public ArrayList<CJRNotification> getmHomeNotification() {
        return this.mHomeNotification;
    }

    public ArrayList<CJRNotification> getmSearchNotification() {
        return this.mSearchNotification;
    }
}
