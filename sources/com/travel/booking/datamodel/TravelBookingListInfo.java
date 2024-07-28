package com.travel.booking.datamodel;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class TravelBookingListInfo extends IJRPaytmDataModel {
    private Body body;
    private String code;
    private String internal_code;
    private Status status;

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getInternal_code() {
        return this.internal_code;
    }

    public final void setInternal_code(String str) {
        this.internal_code = str;
    }

    public final Body getBody() {
        return this.body;
    }

    public final void setBody(Body body2) {
        this.body = body2;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setStatus(Status status2) {
        this.status = status2;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        IJRPaytmDataModel parseResponse = super.parseResponse(str, fVar);
        k.a((Object) parseResponse, "super.parseResponse(p0, p1)");
        return parseResponse;
    }
}
