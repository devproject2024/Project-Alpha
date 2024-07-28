package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusOrderSummaryCancellationPolicy implements IJRDataModel {
    @b(a = "Onward")
    private CJRBusOnwardCancellationPolicy busOnwardCancellationPolicy;

    public CJRBusOnwardCancellationPolicy getBusOnwardCancellationPolicy() {
        return this.busOnwardCancellationPolicy;
    }

    public void setBusOnwardCancellationPolicy(CJRBusOnwardCancellationPolicy cJRBusOnwardCancellationPolicy) {
        this.busOnwardCancellationPolicy = cJRBusOnwardCancellationPolicy;
    }
}
