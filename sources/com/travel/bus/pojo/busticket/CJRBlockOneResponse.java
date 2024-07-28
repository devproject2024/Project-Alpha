package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBlockOneResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRBlockOneModel blockResponse;

    public CJRBlockOneModel getBlockResponse() {
        return this.blockResponse;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}
