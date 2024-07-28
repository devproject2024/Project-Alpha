package com.business.merchant_payments.event;

public class AcceptPaymentSettingsChangedEvent {
    public boolean isContextRequired = false;

    public boolean isContextRequired() {
        return this.isContextRequired;
    }

    public AcceptPaymentSettingsChangedEvent(boolean z) {
        this.isContextRequired = z;
    }
}
