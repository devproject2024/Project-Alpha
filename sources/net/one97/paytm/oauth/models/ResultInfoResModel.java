package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class ResultInfoResModel extends IJRPaytmDataModel {
    @c(a = "resultCode")
    private final String resultCode;
    @c(a = "resultCodeId")
    private final String resultCodeId;
    @c(a = "resultMsg")
    private final String resultMsg;
    @c(a = "resultStatus")
    private final String resultStatus;

    public final String getResultCode() {
        return this.resultCode;
    }

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }
}
