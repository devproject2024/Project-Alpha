package com.paytm.network.model;

import com.paytm.network.listener.c;

public class PaytmMultipartApiResponseModel {
    private c mApiListener;

    public PaytmMultipartApiResponseModel(c cVar) {
        this.mApiListener = cVar;
    }

    public c getApiListener() {
        return this.mApiListener;
    }

    public void setApiListener(c cVar) {
        this.mApiListener = cVar;
    }
}
