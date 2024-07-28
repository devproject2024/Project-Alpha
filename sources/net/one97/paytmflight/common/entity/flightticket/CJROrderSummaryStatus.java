package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryStatus implements IJRDataModel {
    private CJROrderSummaryMessage message;
    private String result;

    public CJROrderSummaryMessage getMessage() {
        return this.message;
    }

    public void setMessage(CJROrderSummaryMessage cJROrderSummaryMessage) {
        this.message = cJROrderSummaryMessage;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
