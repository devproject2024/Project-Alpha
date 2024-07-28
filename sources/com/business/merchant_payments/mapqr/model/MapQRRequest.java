package com.business.merchant_payments.mapqr.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public class MapQRRequest extends a {
    @c(a = "mappedBy")
    @com.google.gson.a.a
    public String mappedBy;
    @c(a = "qrCodeId")
    @com.google.gson.a.a
    public String qrcodeid;

    public MapQRRequest(String str, String str2) {
        this.qrcodeid = str;
        this.mappedBy = str2;
    }

    public String getQrcodeid() {
        return this.qrcodeid;
    }

    public String getMappedBy() {
        return this.mappedBy;
    }
}
