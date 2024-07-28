package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTDRTravellerInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_berth_no")
    private String bookingBerthNo;
    @b(a = "booking_coach_id")
    private String bookingCoachId;
    @b(a = "booking_status")
    private String bookingStatus;
    @b(a = "current_status")
    private String currentStatus;
    @b(a = "is_cancelled")
    private boolean isCancelled;
    @b(a = "tdr_filed")
    private boolean isTDRFiled;
    @b(a = "passenger_age")
    private Integer passengerAge;
    @b(a = "passenger_category")
    private String passengerCategory;
    @b(a = "passenger_gender")
    private String passengerGender;
    @b(a = "passenger_name")
    private String passengerName;
    @b(a = "passenger_nationality")
    private String passengerNationality;
    @b(a = "passenger_serial")
    private Integer passengerSerial;

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public String getBookingCoachId() {
        return this.bookingCoachId;
    }

    public String getBookingBerthNo() {
        return this.bookingBerthNo;
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }

    public String getPassengerCategory() {
        return this.passengerCategory;
    }

    public String getPassengerNationality() {
        return this.passengerNationality;
    }

    public Integer getPassengerAge() {
        return this.passengerAge;
    }

    public String getPassengerGender() {
        return this.passengerGender;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public Integer getPassengerSerial() {
        return this.passengerSerial;
    }

    public boolean isTDRFiled() {
        return this.isTDRFiled;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }
}
