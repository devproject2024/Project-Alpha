package com.business.merchant_payments.event;

import kotlin.g.b.k;

public final class BackPressEvent {
    public final String eventType;

    public BackPressEvent(String str) {
        k.d(str, "eventType");
        this.eventType = str;
    }

    public final String getEventType() {
        return this.eventType;
    }
}
