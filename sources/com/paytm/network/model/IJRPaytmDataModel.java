package com.paytm.network.model;

import com.google.gsonhtcfix.f;
import net.one97.paytm.common.entity.IJRDataModel;

public abstract class IJRPaytmDataModel implements IJRDataModel {
    private NetworkResponse networkResponse;
    private String uniqueRequestId;

    public void setNetworkResponse(NetworkResponse networkResponse2) {
        this.networkResponse = networkResponse2;
    }

    public NetworkResponse getNetworkResponse() {
        return this.networkResponse;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return (IJRPaytmDataModel) fVar.a(str, getClass());
    }

    public String getUniqueRequestId() {
        return this.uniqueRequestId;
    }

    public void setUniqueRequestId(String str) {
        this.uniqueRequestId = str;
    }
}
