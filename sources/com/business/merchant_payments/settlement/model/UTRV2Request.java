package com.business.merchant_payments.settlement.model;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class UTRV2Request {
    @c(a = "settlementBillId")
    @a
    public String settlementbillid;
    @c(a = "settlementEndTime")
    @a
    public String settlementendtime;
    @c(a = "settlementStartTime")
    @a
    public String settlementstarttime;
    @c(a = "settleStatus")
    @a
    public String settlestatus;
    @c(a = "utrNo")
    @a
    public String utrno;

    public UTRV2Request(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.settlementbillid = str2;
        this.settlementstarttime = str4;
        this.settlementendtime = str5;
        this.settlestatus = str6;
        this.utrno = str7;
    }

    public String getSettlementbillid() {
        return this.settlementbillid;
    }

    public String getSettlementstarttime() {
        return this.settlementstarttime;
    }

    public String getSettlementendtime() {
        return this.settlementendtime;
    }

    public String getSettlestatus() {
        return this.settlestatus;
    }

    public String getUtrno() {
        return this.utrno;
    }
}
