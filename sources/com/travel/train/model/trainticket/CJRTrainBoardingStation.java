package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBoardingStation implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "day_count")
    private String mDayCount;
    @b(a = "departure_time")
    private String mDepartureTime;
    @b(a = "station_code")
    private String mStationCode;
    @b(a = "station_name")
    private String mStationName;

    public String getmDepartureTime() {
        return this.mDepartureTime;
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
