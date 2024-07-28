package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusReviewCancellationPolicyBody implements IJRDataModel {
    @b(a = "ONWARD")
    private CJRBusReviewCancellationPolicyOnward policyOnward;

    public CJRBusReviewCancellationPolicyOnward getPolicyOnward() {
        return this.policyOnward;
    }

    public void setPolicyOnward(CJRBusReviewCancellationPolicyOnward cJRBusReviewCancellationPolicyOnward) {
        this.policyOnward = cJRBusReviewCancellationPolicyOnward;
    }
}
