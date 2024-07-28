package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.g;

public abstract class AccountActivationState {
    public AccountActivationState() {
    }

    public /* synthetic */ AccountActivationState(g gVar) {
        this();
    }

    public final boolean isActive() {
        return !(this instanceof DeActivated) && !(this instanceof DeActivatedChangeNotAllowed) && !(this instanceof DeActivatedNotEligibleForInstantReactivation) && !(this instanceof ReActivationFailed) && !(this instanceof ReActivationInProgress) && !(this instanceof DeActivatedEligibleForInstantReactivation);
    }
}
