package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainAvailability extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isBlockedTrain = false;
    @b(a = "booking_allowed")
    private boolean mBookingAllowed;
    @b(a = "date")
    private String mDate;
    private Map<String, String> mFare;
    @b(a = "message")
    private String mMessage;
    @b(a = "message_enabled")
    private boolean mMessageEnable;
    @b(a = "pnr_prediction")
    private CJRPNRPrediction mPNRPrediction;
    private String mQuota = "General";
    private String mQuotaCode = "GN";
    @b(a = "seats")
    private int mSeats;
    @b(a = "status")
    private String mSttaus;
    @b(a = "type")
    private HashMap<String, String> mTypeMap;
    @b(a = "insuranceAlwaysTrue")
    private boolean minsuranceAlwaysTrue;
    @b(a = "insuranceOption")
    private boolean minsuranceOption;

    public boolean isMinsuranceOption() {
        return this.minsuranceOption;
    }

    public boolean isMinsuranceAlwaysTrue() {
        return this.minsuranceAlwaysTrue;
    }

    public boolean isMessageEnable() {
        return this.mMessageEnable;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean isBookingAllowed() {
        return this.mBookingAllowed;
    }

    public HashMap<String, String> getTypeMap() {
        return this.mTypeMap;
    }

    public String getQuota() {
        return this.mQuota;
    }

    public void setQuota(String str) {
        this.mQuota = str;
    }

    public Map<String, String> getFare() {
        return this.mFare;
    }

    public String getmDate() {
        return this.mDate;
    }

    public String getmSttaus() {
        return this.mSttaus;
    }

    public int getmSeats() {
        return this.mSeats;
    }

    public String getmQuotaCode() {
        return this.mQuotaCode;
    }

    public void setmQuotaCode(String str) {
        this.mQuotaCode = str;
    }

    public boolean isBlockedTrain() {
        return this.isBlockedTrain;
    }

    public void setBlockedTrain(boolean z) {
        this.isBlockedTrain = z;
    }

    public CJRPNRPrediction getmPNRPrediction() {
        return this.mPNRPrediction;
    }
}
