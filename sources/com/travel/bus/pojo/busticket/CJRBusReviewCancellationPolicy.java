package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusReviewCancellationPolicy extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRBusReviewCancellationPolicyBody policyBody;

    public CJRBusReviewCancellationPolicyBody getPolicyBody() {
        return this.policyBody;
    }

    public void setPolicyBody(CJRBusReviewCancellationPolicyBody cJRBusReviewCancellationPolicyBody) {
        this.policyBody = cJRBusReviewCancellationPolicyBody;
    }
}
