package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRFJRFlightSessionInfo extends IJRPaytmDataModel {
    @b(a = "session_message")
    private String sessionMessage;
    @b(a = "session_threshold_time")
    private int sessionThresholdTime;
    @b(a = "session_time")
    private int sessionTime;

    public int getSessionTime() {
        return this.sessionTime;
    }

    public void setSessionTime(int i2) {
        this.sessionTime = i2;
    }

    public String getSessionMessage() {
        return this.sessionMessage;
    }

    public void setSessionMessage(String str) {
        this.sessionMessage = str;
    }

    public int getSessionThresholdTime() {
        return this.sessionThresholdTime;
    }

    public void setSessionThresholdTime(int i2) {
        this.sessionThresholdTime = i2;
    }
}
