package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.pojo.bussearch.CJRBusSearchMetaDataV3;

public class CJRNewErrorFormat extends IJRPaytmDataModel {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String error;
    @b(a = "meta")
    private CJRBusSearchMetaDataV3 meta;
    @b(a = "status")
    private i status;

    public String getError() {
        return this.error;
    }

    public Integer getCode() {
        return this.code;
    }

    public i getStatus() {
        return this.status;
    }

    public CJRBusSearchMetaDataV3 getMeta() {
        return this.meta;
    }
}
