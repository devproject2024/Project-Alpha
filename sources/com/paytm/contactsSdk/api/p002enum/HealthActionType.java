package com.paytm.contactsSdk.api.p002enum;

import kotlin.g.b.g;

/* renamed from: com.paytm.contactsSdk.api.enum.HealthActionType  reason: invalid package */
public enum HealthActionType {
    NO_SYNC(0),
    DELTA(1),
    RE_SYNC(2);
    
    public static final Companion Companion = null;
    private final int value;

    private HealthActionType(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((g) null);
    }

    /* renamed from: com.paytm.contactsSdk.api.enum.HealthActionType$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final HealthActionType getAction(int i2) {
            for (HealthActionType healthActionType : HealthActionType.values()) {
                if (healthActionType.getValue() == i2) {
                    return healthActionType;
                }
            }
            return null;
        }
    }
}
