package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainSourceStation implements IJRDataModel {
    @b(a = "day_count")
    private int mDayCount;
    @b(a = "departure_time")
    private String mDepartureTime;
    @b(a = "station_code")
    private String mStationCode;
    @b(a = "station_name")
    private String mStationName;

    public String getStationName() {
        return this.mStationName;
    }

    public String getStationCode() {
        return this.mStationCode;
    }

    public int getDayCount() {
        return this.mDayCount;
    }

    public String getDepartureTime() {
        return this.mDepartureTime;
    }
}
