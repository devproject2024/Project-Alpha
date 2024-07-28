package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRP2bTransaction extends IJRPaytmDataModel {
    @b(a = "merchantOrderId")
    String merchantOrderId;
    @b(a = "message")
    String message;
    @b(a = "status")
    String status;
    @b(a = "txnAmount")
    String txnAmount;
    @b(a = "txnErrorCode")
    String txnErrorCode;
    @b(a = "txnGuid")
    String txnGuid;
    @b(a = "txnType")
    String txnType;

    public String getMerchantOrderId() {
        return this.merchantOrderId;
    }

    public void setMerchantOrderId(String str) {
        this.merchantOrderId = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String getTxnErrorCode() {
        return this.txnErrorCode;
    }

    public void setTxnErrorCode(String str) {
        this.txnErrorCode = str;
    }

    public String getTxnGuid() {
        return this.txnGuid;
    }

    public void setTxnGuid(String str) {
        this.txnGuid = str;
    }

    public String getTxnType() {
        return this.txnType;
    }

    public void setTxnType(String str) {
        this.txnType = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
