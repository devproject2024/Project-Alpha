package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRPromocodeErrorResponse extends IJRPaytmDataModel {
    @b(a = "code")
    private int code;
    @b(a = "error")
    private String error;
    @b(a = "internal_code")
    private String internalCode;
    @b(a = "status")
    private CJRFlightPromoCodeErrorStatus status;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public CJRFlightPromoCodeErrorStatus getStatus() {
        return this.status;
    }

    public void setStatus(CJRFlightPromoCodeErrorStatus cJRFlightPromoCodeErrorStatus) {
        this.status = cJRFlightPromoCodeErrorStatus;
    }

    public Integer getCode() {
        return Integer.valueOf(this.code);
    }

    public void setCode(Integer num) {
        this.code = num.intValue();
    }

    public String getInternalCode() {
        return this.internalCode;
    }

    public void setInternalCode(String str) {
        this.internalCode = str;
    }
}
