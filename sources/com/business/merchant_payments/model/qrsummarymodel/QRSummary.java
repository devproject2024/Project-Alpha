package com.business.merchant_payments.model.qrsummarymodel;

import com.business.common_module.f.a;
import com.google.gson.a.c;
import java.util.ArrayList;

public class QRSummary extends a {
    @c(a = "orderId")
    public String mOrderID;
    @c(a = "response")
    public ArrayList<QRSummaryListItem> mQRSummaryList;
    @c(a = "requestGuid")
    public String mRequestGUID;
    @c(a = "status")
    public String mStatus;
    @c(a = "statusCode")
    public String mStatusCode;
    @c(a = "statusMessage")
    public String mStatusMessage;

    public String getmRequestGUID() {
        return this.mRequestGUID;
    }

    public String getmOrderID() {
        return this.mOrderID;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public String getmStatusCode() {
        return this.mStatusCode;
    }

    public String getmStatusMessage() {
        return this.mStatusMessage;
    }

    public ArrayList<QRSummaryListItem> getmQRSummaryList() {
        return this.mQRSummaryList;
    }
}
