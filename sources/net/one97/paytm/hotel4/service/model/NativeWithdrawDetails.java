package net.one97.paytm.hotel4.service.model;

import com.paytm.network.model.IJRPaytmDataModel;

public final class NativeWithdrawDetails extends IJRPaytmDataModel {
    private Boolean authenticated;
    private String txnToken;

    public final Boolean getAuthenticated() {
        return this.authenticated;
    }

    public final void setAuthenticated(Boolean bool) {
        this.authenticated = bool;
    }

    public final String getTxnToken() {
        return this.txnToken;
    }

    public final void setTxnToken(String str) {
        this.txnToken = str;
    }
}
