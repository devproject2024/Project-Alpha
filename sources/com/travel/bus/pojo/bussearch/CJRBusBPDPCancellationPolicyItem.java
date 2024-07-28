package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusBPDPCancellationPolicyItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    public CJRBPDPCancellationBody body;

    public CJRBPDPCancellationBody getBody() {
        return this.body;
    }
}
