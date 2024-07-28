package net.one97.paytmflight.common.entity.flightticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightOrderSummaryResponse extends IJRPaytmDataModel implements IJRDataModel {
    private CJROrderSummaryBody body;
    private String code;
    private String error;
    private CJROrderSummaryStatus status;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public CJROrderSummaryStatus getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public CJROrderSummaryBody getBody() {
        return this.body;
    }
}
