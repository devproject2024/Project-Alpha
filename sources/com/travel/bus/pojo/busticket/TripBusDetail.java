package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class TripBusDetail extends IJRPaytmDataModel {
    @a
    @b(a = "body")
    private ArrayList<TripBusDetailsItem> body = new ArrayList<>();
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "error")
    private Object error;
    @a
    @b(a = "meta")
    private TripDetailsMeta meta;
    @a
    @b(a = "status")
    private TripBusDetailsStatus status;

    public Object getError() {
        return this.error;
    }

    public void setError(Object obj) {
        this.error = obj;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public TripBusDetailsStatus getStatus() {
        return this.status;
    }

    public void setStatus(TripBusDetailsStatus tripBusDetailsStatus) {
        this.status = tripBusDetailsStatus;
    }

    public ArrayList<TripBusDetailsItem> getBody() {
        return this.body;
    }

    public void setBody(ArrayList<TripBusDetailsItem> arrayList) {
        this.body = arrayList;
    }

    public TripDetailsMeta getMeta() {
        return this.meta;
    }

    public void setMeta(TripDetailsMeta tripDetailsMeta) {
        this.meta = tripDetailsMeta;
    }
}
