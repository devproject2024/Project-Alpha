package com.paytm.network.model;

import com.paytm.network.listener.b;

public class PaytmCommonApiResponseModel {
    private b mApiListener;

    public PaytmCommonApiResponseModel(b bVar) {
        this.mApiListener = bVar;
    }

    public b getApiListener() {
        return this.mApiListener;
    }

    public void setApiListener(b bVar) {
        this.mApiListener = bVar;
    }
}
