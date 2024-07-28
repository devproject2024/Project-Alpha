package net.one97.paytm.common.entity.verifier;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifierHead implements IJRDataModel {
    @b(a = "accessToken")
    private String accessToken;
    @b(a = "clientId")
    private String clientId;
    @b(a = "function")
    private String function;
    @b(a = "reqMsgId")
    private String reqMsgId;
    @b(a = "respTime")
    private String respTime;
    @b(a = "version")
    private String version;

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public String getReqMsgId() {
        return this.reqMsgId;
    }

    public void setReqMsgId(String str) {
        this.reqMsgId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getRespTime() {
        return this.respTime;
    }

    public void setRespTime(String str) {
        this.respTime = str;
    }
}
