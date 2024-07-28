package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CashbackVoucherListModal extends IJRPaytmDataModel {
    @b(a = "response")
    private CashbackVoucherResponse response;
    private String status;

    public CashbackVoucherResponse getResponse() {
        return this.response;
    }

    public void setResponse(CashbackVoucherResponse cashbackVoucherResponse) {
        this.response = cashbackVoucherResponse;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
