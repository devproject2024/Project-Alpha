package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.CJRFlightPromoBody;
import com.travel.flight.pojo.CJRFlightPromoMeta;

public class CJRFlightPromoResponse extends IJRPaytmDataModel {
    @a
    @b(a = "body")
    private CJRFlightPromoBody body;
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "error")
    private Object error;
    @a
    @b(a = "meta")
    private CJRFlightPromoMeta meta;
    @a
    @b(a = "status")
    private FlightStatus status;

    public Object getError() {
        return this.error;
    }

    public void setError(Object obj) {
        this.error = obj;
    }

    public FlightStatus getStatus() {
        return this.status;
    }

    public void setStatus(FlightStatus flightStatus) {
        this.status = flightStatus;
    }

    public CJRFlightPromoBody getBody() {
        return this.body;
    }

    public void setBody(CJRFlightPromoBody cJRFlightPromoBody) {
        this.body = cJRFlightPromoBody;
    }

    public CJRFlightPromoMeta getMeta() {
        return this.meta;
    }

    public void setMeta(CJRFlightPromoMeta cJRFlightPromoMeta) {
        this.meta = cJRFlightPromoMeta;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }
}
