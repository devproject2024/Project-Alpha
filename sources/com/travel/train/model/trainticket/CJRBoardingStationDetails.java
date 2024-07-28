package com.travel.train.model.trainticket;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBoardingStationDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "dayCount")
    private int mDayCount;
    @b(a = "departureTime")
    private String mDepartureTime;
    @b(a = "stationCode")
    private String mStationCode;

    public String getDepartureTime() {
        return !TextUtils.isEmpty(this.mDepartureTime) ? this.mDepartureTime : "";
    }

    public int getDayCount() {
        return this.mDayCount;
    }

    public String getmStationCode() {
        return this.mStationCode;
    }
}
