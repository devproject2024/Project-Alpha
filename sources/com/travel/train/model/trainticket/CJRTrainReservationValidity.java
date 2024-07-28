package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainReservationValidity implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "arrival_time")
    private String mArrivalTime;
    @b(a = "day_count")
    private String mDayCount;
    @b(a = "station_code")
    private String mStationCode;
    @b(a = "station_name")
    private String mStationName;

    public String getmArrivalTime() {
        return this.mArrivalTime;
    }

    public String getmDayCount() {
        return this.mDayCount;
    }

    public String getmStationCode() {
        return this.mStationCode;
    }

    public String getmStationName() {
        return this.mStationName;
    }
}
