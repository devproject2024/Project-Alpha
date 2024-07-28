package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPNRPAXInformation implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "bookingBerthCode")
    private String mBookingBirthCode;
    @b(a = "bookingBerthNo")
    private String mBookingBirthNo;
    @b(a = "bookingCoachId")
    private String mBookingCoachId;
    @b(a = "bookingStatus")
    private String mBookingStatus;
    @b(a = "bookingStatusIndex")
    private String mBookingStatusIndex;
    @b(a = "currentBerthCode")
    private String mCurrentBerthCode;
    @b(a = "currentBerthNo")
    private String mCurrentBerthNo;
    @b(a = "currentCoachId")
    private String mCurrentCoachId;
    @b(a = "currentStatus")
    private String mCurrentStatus;
    @b(a = "currentStatusIndex")
    private String mCurrentStatusIndex;
    @b(a = "passengerBerthChoice")
    private String mPassengerBerthChoice;
    @b(a = "passengerIcardFlag")
    private String mPassengerICardFlag;
    @b(a = "passengerName")
    private String mPassengerName;
    @b(a = "passengerSerialNumber")
    private String mPassengerSerialNo;
    @b(a = "probabilityDisplay")
    private String mprobabilityDisplay;

    public String isMprobabilityDisplay() {
        return this.mprobabilityDisplay;
    }

    public String getmBookingBirthCode() {
        return this.mBookingBirthCode;
    }

    public String getmBookingBirthNo() {
        return this.mBookingBirthNo;
    }

    public String getmBookingCoachId() {
        return this.mBookingCoachId;
    }

    public String getmCurrentStatus() {
        return this.mCurrentStatus;
    }

    public String getmBookingStatus() {
        return this.mBookingStatus;
    }

    public String getmBookingStatusIndex() {
        return this.mBookingStatusIndex;
    }

    public String getmCurrentBerthNo() {
        return this.mCurrentBerthNo;
    }

    public String getmCurrentCoachId() {
        return this.mCurrentCoachId;
    }

    public String getmCurrentStatusIndex() {
        return this.mCurrentStatusIndex;
    }

    public String getmPassengerBerthChoice() {
        return this.mPassengerBerthChoice;
    }

    public String getmPassengerICardFlag() {
        return this.mPassengerICardFlag;
    }

    public String getmPassengerSerialNo() {
        return this.mPassengerSerialNo;
    }

    public String getmPassengerName() {
        return this.mPassengerName;
    }

    public String getCurrentBerthCode() {
        return this.mCurrentBerthCode;
    }
}
