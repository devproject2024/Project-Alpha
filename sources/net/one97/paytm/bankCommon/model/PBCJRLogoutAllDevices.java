package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBCJRLogoutAllDevices extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "httpStatus")
    private boolean httpStatus;
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public boolean getHTTPSuccess() {
        return this.httpStatus;
    }

    public void setHTTPSuccess(boolean z) {
        this.httpStatus = z;
    }
}
