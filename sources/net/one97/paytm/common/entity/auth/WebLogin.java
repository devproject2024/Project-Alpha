package net.one97.paytm.common.entity.auth;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class WebLogin extends CJRWalletDataModel implements IJRDataModel {
    public static final String RESPONSE_CODE_SUCCESS = "01";
    public static final String STATUS_SUCCESS = "SUCCESS";
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.status;
    }
}
