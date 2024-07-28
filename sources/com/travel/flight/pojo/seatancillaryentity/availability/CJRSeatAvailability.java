package com.travel.flight.pojo.seatancillaryentity.availability;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatBody;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatStatus;

public class CJRSeatAvailability extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "body")
    private CJRSeatBody CJRSeatBody;
    @a
    @b(a = "meta")
    private CJRSeatMeta CJRSeatMeta;
    @a
    @b(a = "status")
    private CJRSeatStatus CJRSeatStatus;
    @a
    @b(a = "code")
    private int code;
    @a
    @b(a = "error")
    private String error;

    public Object getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public CJRSeatStatus getCJRSeatStatus() {
        return this.CJRSeatStatus;
    }

    public void setCJRSeatStatus(CJRSeatStatus cJRSeatStatus) {
        this.CJRSeatStatus = cJRSeatStatus;
    }

    public CJRSeatBody getCJRSeatBody() {
        return this.CJRSeatBody;
    }

    public void setCJRSeatBody(CJRSeatBody cJRSeatBody) {
        this.CJRSeatBody = cJRSeatBody;
    }

    public CJRSeatMeta getCJRSeatMeta() {
        return this.CJRSeatMeta;
    }

    public void setCJRSeatMeta(CJRSeatMeta cJRSeatMeta) {
        this.CJRSeatMeta = cJRSeatMeta;
    }

    public Integer getCode() {
        return Integer.valueOf(this.code);
    }

    public void setCode(Integer num) {
        this.code = num.intValue();
    }
}
