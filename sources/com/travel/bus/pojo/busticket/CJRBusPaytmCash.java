package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;

public class CJRBusPaytmCash extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestGuid;
    @b(a = "response")
    private CJRCashWalletResponse mResponse;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "type")
    private String mType;

    public Object getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public Object getRequestGuid() {
        return this.mRequestGuid;
    }

    public void setRequestGuid(String str) {
        this.mRequestGuid = str;
    }

    public Object getOrderId() {
        return this.mOrderId;
    }

    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(String str) {
        this.mStatusCode = str;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public void setStatusMessage(String str) {
        this.mStatusMessage = str;
    }

    public CJRCashWalletResponse getResponse() {
        return this.mResponse;
    }

    public void setResponse(CJRCashWalletResponse cJRCashWalletResponse) {
        this.mResponse = cJRCashWalletResponse;
    }

    public String toString() {
        return new f().a((Object) this);
    }
}
