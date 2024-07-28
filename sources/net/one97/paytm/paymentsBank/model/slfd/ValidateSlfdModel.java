package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ValidateSlfdModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "limit_breach")
    private boolean limitBreach;
    @b(a = "message")
    private String message;
    @b(a = "response_code")
    private Integer responseCode = 0;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txnId;

    public final boolean getLimitBreach() {
        return this.limitBreach;
    }

    public final void setLimitBreach(boolean z) {
        this.limitBreach = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }
}
