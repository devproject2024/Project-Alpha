package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMIniRules implements IJRDataModel {
    @b(a = "baggage_policy")
    private CJRMiniRulePolicy baggagePolicy;
    @b(a = "cancellation_policy")
    private CJRMiniRulePolicy cancellationPolicy;
    @b(a = "modification_policy")
    private CJRMiniRulePolicy modificationPolicy;

    public CJRMiniRulePolicy getBaggagePolicy() {
        return this.baggagePolicy;
    }

    public CJRMiniRulePolicy getCancellationPolicy() {
        return this.cancellationPolicy;
    }

    public CJRMiniRulePolicy getModificationPolicy() {
        return this.modificationPolicy;
    }
}
