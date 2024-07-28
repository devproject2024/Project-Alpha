package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction;

public class CJRActionResponse extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "actions")
    private ArrayList<CJROrderSummaryAction> mActions;
    @b(a = "error")
    private String mError;
    @b(a = "message")
    private String mMessage;
    @b(a = "title ")
    private String mTitle;
    private String requestUrl;

    public String getTitle() {
        return this.mTitle;
    }

    public String getError() {
        return this.mError;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public ArrayList<CJROrderSummaryAction> getActions() {
        return this.mActions;
    }

    public void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRActionResponse cJRActionResponse = (CJRActionResponse) fVar.a(str, getClass());
        cJRActionResponse.setRequestUrl(getRequestUrl());
        return cJRActionResponse;
    }
}
