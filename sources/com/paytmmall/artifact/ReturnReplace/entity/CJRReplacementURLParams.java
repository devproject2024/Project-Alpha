package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRReplacementURLParams extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CJRURLParamsBody mData;
    @b(a = "method")
    private String mMethod;
    @b(a = "url")
    private String mUrl;

    public String getUrl() {
        return this.mUrl;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public CJRURLParamsBody getData() {
        return this.mData;
    }
}
