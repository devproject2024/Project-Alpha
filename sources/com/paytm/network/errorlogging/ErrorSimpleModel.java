package com.paytm.network.errorlogging;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class ErrorSimpleModel extends IJRPaytmDataModel {
    public String jsonData;

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        this.jsonData = str;
        return this;
    }
}
