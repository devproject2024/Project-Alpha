package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickBookBoardingStation implements IJRDataModel {
    @b(a = "dayCount")
    private String mDayCount;
    @b(a = "departureTime")
    private String mDepartureTime;
    @b(a = "stationCode")
    private String mStationCode;

    public String getDepartureTime() {
        return this.mDepartureTime;
    }

    public String getDayCount() {
        return this.mDayCount;
    }

    public String getmStationCode() {
        return this.mStationCode;
    }
}
