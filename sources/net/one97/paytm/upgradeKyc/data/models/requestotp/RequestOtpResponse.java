package net.one97.paytm.upgradeKyc.data.models.requestotp;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public final class RequestOtpResponse extends IJRPaytmDataModel {
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "otpResponse")
    private ArrayList<OtpResponse> otpResponse;
    @a
    @b(a = "requestId")
    private String requestId;
    @a
    @b(a = "responseCode")
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

    public final ArrayList<OtpResponse> getOtpResponse() {
        return this.otpResponse;
    }

    public final void setOtpResponse(ArrayList<OtpResponse> arrayList) {
        this.otpResponse = arrayList;
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
}
