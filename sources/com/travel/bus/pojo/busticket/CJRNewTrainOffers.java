package com.travel.bus.pojo.busticket;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRNewTrainOffers extends IJRPaytmDataModel {
    private String code;
    private String error;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }
}
