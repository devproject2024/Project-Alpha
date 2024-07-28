package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CashbackVoucherDetailsResponse extends IJRPaytmDataModel {
    @b(a = "response")
    private MyVoucherDetailsResData response;
    private String status;

    public final MyVoucherDetailsResData getResponse() {
        return this.response;
    }

    public final void setResponse(MyVoucherDetailsResData myVoucherDetailsResData) {
        this.response = myVoucherDetailsResData;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
