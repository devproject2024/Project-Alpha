package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStationList extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isDestination;
    private boolean isSource;
    @b(a = "arrivalTime")
    private String mArrivalTime;
    @b(a = "dayCount")
    private String mDayCount;
    @b(a = "departureTime")
    private String mDepartureTime;
    @b(a = "distance")
    private String mDistance;
    @b(a = "haltTime")
    private String mHaltTime;
    @b(a = "routeNumber")
    private String mRouteNumber;
    @b(a = "stationCode")
    private String mStationCode;
    @b(a = "stationName")
    private String mStationName;
    @b(a = "stnSerialNumber")
    private String mStnSerialNumber;
    private String mTrainDay;

    public String getTrainDay() {
        return this.mTrainDay;
    }

    public void setTrainDay(String str) {
        this.mTrainDay = str;
    }

    public boolean isDestination() {
        return this.isDestination;
    }

    public void setIsDestination(boolean z) {
        this.isDestination = z;
    }

    public boolean isSource() {
        return this.isSource;
    }

    public void setSource(boolean z) {
        this.isSource = z;
    }

    public String getmDistance() {
        return this.mDistance;
    }

    public String getmArrivalTime() {
        return this.mArrivalTime;
    }

    public String getmDepartureTime() {
        return this.mDepartureTime;
    }

    public String getmRouteNumber() {
        return this.mRouteNumber;
    }

    public String getmStationName() {
        return this.mStationName;
    }

    public String getmStationCode() {
        return this.mStationCode;
    }

    public String getmDayCount() {
        return this.mDayCount;
    }

    public String getmHaltTime() {
        return this.mHaltTime;
    }

    public String getmStnSerialNumber() {
        return this.mStnSerialNumber;
    }
}
