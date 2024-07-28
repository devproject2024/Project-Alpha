package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROTPStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String mErrorMsg;
    @b(a = "status")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }
}
