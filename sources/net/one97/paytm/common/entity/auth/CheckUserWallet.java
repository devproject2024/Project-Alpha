package net.one97.paytm.common.entity.auth;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CheckUserWallet extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "state")
    private String mState;
    @b(a = "status")
    private String mStatus;
    @b(a = "walletType")
    private String mWalletType;

    public String getWalletType() {
        return this.mWalletType;
    }

    public String getState() {
        return this.mState;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }
}
