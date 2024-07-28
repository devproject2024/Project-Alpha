package net.one97.paytm.recharge.model.creditcard;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCreditCardToken extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "ErrorCode")
    private String mErrorCode;
    @b(a = "ErrorMsg")
    private String mErrorMsg;
    @b(a = "STATUS")
    private String mStatus;
    @b(a = "TOKEN")
    private String mToken;

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }
}
