package com.travel.bus.pojo.busticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class BusRecentsData implements IJRDataModel {
    private String date;
    private long dateValue;
    private CJRBusOriginCityItem destination;
    private CJRBusOriginCityItem source;

    public CJRBusOriginCityItem getSource() {
        return this.source;
    }

    public void setSource(CJRBusOriginCityItem cJRBusOriginCityItem) {
        this.source = cJRBusOriginCityItem;
    }

    public CJRBusOriginCityItem getDestination() {
        return this.destination;
    }

    public void setDestination(CJRBusOriginCityItem cJRBusOriginCityItem) {
        this.destination = cJRBusOriginCityItem;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public long getDateValue() {
        return this.dateValue;
    }

    public void setDateValue(long j) {
        this.dateValue = j;
    }
}
