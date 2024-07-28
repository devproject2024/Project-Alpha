package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroRouteSearchResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    CJRMetroSearchRouteBodyModel body;
    @b(a = "httpStatus")
    int httpStatus;
    @b(a = "info")
    CJRMetroInfoModel info;
    @b(a = "internalCode")
    String internalCode;
    @b(a = "meta")
    CJRMetroMetaModel meta;
    @b(a = "result")
    String result;

    public String getResult() {
        return this.result;
    }

    public String getInternalCode() {
        return this.internalCode;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public CJRMetroInfoModel getInfo() {
        return this.info;
    }

    public CJRMetroMetaModel getMeta() {
        return this.meta;
    }

    public CJRMetroSearchRouteBodyModel getBody() {
        return this.body;
    }

    public void setBody(CJRMetroSearchRouteBodyModel cJRMetroSearchRouteBodyModel) {
        this.body = cJRMetroSearchRouteBodyModel;
    }
}
