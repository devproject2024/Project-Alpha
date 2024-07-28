package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PBCJRContingency extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "close")
    private boolean mClose;
    @b(a = "message")
    private String mMessage;
    @b(a = "status")
    private boolean mStatus;
    @b(a = "url")
    private String mUrl;

    public boolean getStatus() {
        return this.mStatus;
    }

    public boolean getClose() {
        return this.mClose;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getUrl() {
        return this.mUrl;
    }
}
