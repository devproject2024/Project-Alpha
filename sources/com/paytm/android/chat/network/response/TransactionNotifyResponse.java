package com.paytm.android.chat.network.response;

import com.paytm.network.model.IJRPaytmDataModel;

public class TransactionNotifyResponse extends IJRPaytmDataModel {
    private String respCode;
    private String respMessage;
    private String status;
    private String txnid;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String str) {
        this.respCode = str;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public void setRespMessage(String str) {
        this.respMessage = str;
    }

    public String getTxnid() {
        return this.txnid;
    }

    public void setTxnid(String str) {
        this.txnid = str;
    }
}
