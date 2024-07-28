package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPNRStatusDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "boarding_station")
    private CJRTrainBoardingStation mBoardingStation;
    @a
    @b(a = "chart_prepared")
    private Boolean mChartingStatus;
    @b(a = "class")
    private String mClass;
    @b(a = "date")
    private String mDate;
    @b(a = "no_of_passengers")
    private String mNoOfPassenger;
    @b(a = "order_id")
    private String mOrderId;
    @b(a = "pax_info")
    private ArrayList<CJRPNRPAXInformation> mPAXInfoList;
    @b(a = "pnr_number")
    private String mPNRNumber;
    @b(a = "pnr_prediction")
    private CJRPNRPrediction mPNRPrediction;
    @b(a = "pnr_message")
    private String mPnrMessage;
    @b(a = "quota")
    private String mQuota;
    @b(a = "reservation_upto")
    private CJRTrainReservationValidity mReservationUpTo;
    @b(a = "source_station")
    private CJRTrainSourceStation mSourceStation;
    @b(a = "train_name")
    private String mTrainName;
    @b(a = "train_number")
    private String mTrainNumber;
    @a
    @b(a = "tip_enabled")
    private boolean tipEnabled;
    @a
    @b(a = "tip_text")
    private String tipText;

    public String getOrderId() {
        return this.mOrderId;
    }

    public boolean isTipEnabled() {
        return this.tipEnabled;
    }

    public String getTipText() {
        return this.tipText;
    }

    public Boolean getmChartingStatus() {
        return this.mChartingStatus;
    }

    public String getmQuota() {
        return this.mQuota;
    }

    public CJRTrainSourceStation getSourceStation() {
        return this.mSourceStation;
    }

    public String getmPNRNumber() {
        return this.mPNRNumber;
    }

    public String getmNoOfPassenger() {
        return this.mNoOfPassenger;
    }

    public String getmDate() {
        return this.mDate;
    }

    public String getmClass() {
        return this.mClass;
    }

    public String getmTrainName() {
        return this.mTrainName;
    }

    public String getmTrainNumber() {
        return this.mTrainNumber;
    }

    public ArrayList<CJRPNRPAXInformation> getmPAXInfoList() {
        return this.mPAXInfoList;
    }

    public CJRTrainBoardingStation getmBoardingStation() {
        return this.mBoardingStation;
    }

    public CJRTrainReservationValidity getmReservationUpTo() {
        return this.mReservationUpTo;
    }

    public String getPnrMessage() {
        return this.mPnrMessage;
    }

    public CJRPNRPrediction getPNRPrediction() {
        return this.mPNRPrediction;
    }
}
