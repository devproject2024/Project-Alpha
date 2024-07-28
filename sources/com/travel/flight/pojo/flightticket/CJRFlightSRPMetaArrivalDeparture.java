package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightSRPMetaArrivalDeparture implements IJRDataModel {
    private String max;
    private String max_datetime;
    private long max_timestamp;
    private String min;
    private String min_datetime;
    private long min_timestamp;
    private String timezone;

    public String getMin_datetime() {
        return this.min_datetime;
    }

    public void setMin_datetime(String str) {
        this.min_datetime = str;
    }

    public String getMax_datetime() {
        return this.max_datetime;
    }

    public void setMax_datetime(String str) {
        this.max_datetime = str;
    }

    public String getMin() {
        return this.min;
    }

    public void setMin(String str) {
        this.min = str;
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String str) {
        this.max = str;
    }

    public long getMin_timestamp() {
        return this.min_timestamp;
    }

    public void setMin_timestamp(long j) {
        this.min_timestamp = j;
    }

    public long getMax_timestamp() {
        return this.max_timestamp;
    }

    public void setMax_timestamp(long j) {
        this.max_timestamp = j;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }
}
