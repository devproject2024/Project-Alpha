package net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class ValidateTokenApiResponse extends IJRPaytmDataModel {
    @a
    @b(a = "data")
    private TokenData data;
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "request_id")
    private String requestId;
    @a
    @b(a = "response_code")
    private Integer responseCode;
    @a
    @b(a = "status")
    private String status;

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final TokenData getData() {
        return this.data;
    }

    public final void setData(TokenData tokenData) {
        this.data = tokenData;
    }
}
