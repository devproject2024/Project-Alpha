package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDCAtmPinSetResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "errorCode")
    private String errorCode;
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "status")
    private String status;

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public String getmStatusCode() {
        return this.mStatusCode;
    }

    public void setmStatusCode(String str) {
        this.mStatusCode = str;
    }

    public String getmStatusMessage() {
        return this.mStatusMessage;
    }

    public void setmStatusMessage(String str) {
        this.mStatusMessage = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
