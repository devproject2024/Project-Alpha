package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickSchedule implements IJRDataModel {
    @b(a = "stationList")
    private ArrayList<CJRTrainQuickBookBoardingStation> mBoardingDetail;
    @b(a = "trainName")
    private String mTrainName;
    @b(a = "trainNumber")
    private String mTrainNumber;

    public String getmTrainName() {
        return this.mTrainName;
    }

    public String getmTrainNumber() {
        return this.mTrainNumber;
    }

    public ArrayList<CJRTrainQuickBookBoardingStation> getmBoardingDetail() {
        return this.mBoardingDetail;
    }
}
