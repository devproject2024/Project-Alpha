package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;

public class RandRReplacementResponseModel extends RandResponseModel {
    @b(a = "ORDERID")
    private String ORDERID;
    @b(a = "ORDER_ID")
    private String ORDER_ID;
    @b(a = "THEME")
    private String THEME;
    @b(a = "TOKEN_TYPE")
    private String TOKEN_TYPE;
    private String error;
    @b(a = "hitPG")
    private String hitPG;
    @b(a = "pgUrlToHit")
    private String pgUrlToHit;
    public String status;

    public String getStatus() {
        return this.status;
    }

    public String getOrderId() {
        return this.ORDERID;
    }

    public String getORDER_ID() {
        return this.ORDER_ID;
    }

    public String getTOKEN_TYPE() {
        return this.TOKEN_TYPE;
    }

    public String getTHEME() {
        return this.THEME;
    }

    public String getError() {
        return this.error;
    }

    public String getMessage() {
        return this.message;
    }

    public String getHitPG() {
        return this.hitPG;
    }

    public String getPgUrlToHit() {
        return this.pgUrlToHit;
    }
}
