package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSummaryActionCallItem implements IJRDataModel {
    /* access modifiers changed from: private */
    public String body;
    /* access modifiers changed from: private */
    public boolean isReturnReplace;
    /* access modifiers changed from: private */
    public String url;

    public String getUrl() {
        return this.url;
    }

    public String getBody() {
        return this.body;
    }

    public boolean isReturnReplace() {
        return this.isReturnReplace;
    }
}
