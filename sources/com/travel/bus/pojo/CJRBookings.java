package com.travel.bus.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBookings extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "boarding_date")
    private String mBoardingDate;
    @b(a = "boarding")
    private String mBoardingStationCode;
    @b(a = "boarding_name")
    private String mBoardingStationName;
    @b(a = "order_id")
    private String mOrderID;
    @b(a = "reservation_upto")
    private String mReservationUpToStationCode;
    @b(a = "reservation_upto_name")
    private String mReservationUpToStationName;
    @b(a = "train_name")
    private String mTrainName;
    @b(a = "train_number")
    private String mTrainNumber;

    public String getTrainName() {
        return this.mTrainName;
    }

    public String getTrainNumber() {
        return this.mTrainNumber;
    }

    public String getmBoardingDate() {
        return this.mBoardingDate;
    }

    public String getmBoardingStationCode() {
        return this.mBoardingStationCode;
    }

    public String getmReservationUpToStationCode() {
        return this.mReservationUpToStationCode;
    }

    public String getmOrderID() {
        return this.mOrderID;
    }

    public String getmBoardingStationName() {
        return this.mBoardingStationName;
    }

    public String getmReservationUpToStationName() {
        return this.mReservationUpToStationName;
    }
}
