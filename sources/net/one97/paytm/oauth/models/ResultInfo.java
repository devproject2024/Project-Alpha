package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class ResultInfo extends IJRPaytmDataModel {
    @b(a = "resultCode")
    private final String resultCode;
    @b(a = "resultCodeId")
    private final String resultCodeId;
    @b(a = "resultMsg")
    private final String resultMsg;
    @b(a = "resultStatus")
    private final String resultStatus;

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }
}
