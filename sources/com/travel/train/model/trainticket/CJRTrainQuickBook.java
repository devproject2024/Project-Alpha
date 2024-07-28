package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRStatusError;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrainQuickBook extends IJRPaytmDataModel {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String mError;
    @b(a = "status")
    private CJRStatusError mStatus;
    @b(a = "body")
    private CJRTrainQuickBookBody mTrainQuickBookBody;
    @b(a = "meta")
    public CJRTrainSearchResultsMeta meta;

    public String getmError() {
        return this.mError;
    }

    public CJRStatusError getmStatus() {
        return this.mStatus;
    }

    public CJRTrainQuickBookBody getmTrainQuickBookBody() {
        return this.mTrainQuickBookBody;
    }

    public CJRTrainSearchResultsMeta getMeta() {
        return this.meta;
    }

    public void setMeta(CJRTrainSearchResultsMeta cJRTrainSearchResultsMeta) {
        this.meta = cJRTrainSearchResultsMeta;
    }
}
