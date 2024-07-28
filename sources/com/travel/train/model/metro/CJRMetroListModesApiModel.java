package com.travel.train.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroListModesApiModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRMetroListModeBodyModel body;
    @b(a = "httpStatus")
    private int httpStatus;
    @b(a = "info")
    private CJRMetroInfoModel info;
    @b(a = "internalCode")
    private String internalCode;
    @b(a = "meta")
    private CJRMetroMetaModel meta;
    @b(a = "result")
    private String result;

    public CJRMetroListModeBodyModel getBody() {
        return this.body;
    }

    public CJRMetroMetaModel getMeta() {
        return this.meta;
    }

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
}
